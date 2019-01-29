package com.xinre.redis.util;

import com.xinre.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * 简单限流算法
 * 使用滑动时间窗口（period）实现，缺点：记录时间窗口内所有的行为记录
 *
 * @author xinre
 * @date 2019/1/25 11:28
 */
public class SimpleRateLimiter {

    @Autowired
    private Jedis jedis;

    @Autowired
    private IdWorker idWorker;

    public SimpleRateLimiter(Jedis jedis, IdWorker idWorker) {
        this.jedis = jedis;
        this.idWorker = idWorker;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        String member = String.valueOf(idWorker.nextId());
        System.out.println("key = " + key + "  ||  score = " + nowTs + "  ||  value = " + member);
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, member);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        JedisPool jedisPool = new JedisPool("192.168.100.109", 6379);
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedisPool.getResource(), new IdWorker());
        for (int i = 0; i < 20; i++) {
            System.out.println("i = " + i);
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 5, 5));

            System.out.println(" ================over================= ");
        }
    }
}
