package com.xinre.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * @author xinre
 * @date 2019/1/25 11:28
 */
public class SimpleRateLimiter {

    @Autowired
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        System.out.println("key = " + key + "  ||  value = " + nowTs);
        Pipeline pipe = jedis.pipelined();
        Response<String> multi = pipe.multi();
        

        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        JedisPool jedisPool = new JedisPool("192.168.100.109", 6379);
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedisPool.getResource());
        for (int i = 0; i < 20; i++) {
            System.out.println("i = " + i);
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));

            System.out.println(" ================over================= ");
        }
    }
}
