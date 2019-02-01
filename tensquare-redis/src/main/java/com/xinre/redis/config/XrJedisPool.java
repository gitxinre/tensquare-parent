package com.xinre.redis.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 封装JedisPool使其更加优雅的关闭资源
 *
 * @author xinre
 * @date 2019/2/1 16:22
 */
@Component
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class XrJedisPool {

    @Autowired
    private JedisPool jedisPool;

    void execute(CallWithJedis caller) {
        try (Jedis jedis = jedisPool.getResource()) {
            caller.call(jedis);
        }
    }

    public void executeTryAgain(CallWithJedis caller) {
        Jedis jedis = jedisPool.getResource();
        try {
            caller.call(jedis);
        } catch (Exception e) {
            log.info("Jedis 异常进行重试……");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            caller.call(jedis);
            log.info("Jedis 重试成功……");
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}
