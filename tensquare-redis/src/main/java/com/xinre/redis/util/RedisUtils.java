package com.xinre.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * @author xinre
 * @date 2019/1/24 10:17
 */
@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private JedisCluster jedisCluster;


}
