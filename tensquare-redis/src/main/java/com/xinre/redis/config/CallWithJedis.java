package com.xinre.redis.config;

import redis.clients.jedis.Jedis;

/**
 * @author xinre
 * @date 2019/2/1 16:25
 */
public interface CallWithJedis {
    void call(Jedis jedis);
}
