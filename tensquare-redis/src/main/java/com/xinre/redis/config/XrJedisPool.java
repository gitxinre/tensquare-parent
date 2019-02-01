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

    public void execute(CallWithJedis caller) {
        try (Jedis jedis = jedisPool.getResource()) {
            caller.call(jedis);
        }
    }

}
