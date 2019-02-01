package com.xinre.redis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xinre
 * @date 2019/2/1 16:41
 */
public class XrJedisPoolTest {

    public static void main(String[] args) {
        XrJedisPool jedis = new XrJedisPool(new JedisPool("192.168.100.109", 6379));
        XrHolder<Long> count = new XrHolder<>();
        Long l = 0L;
        jedis.execute(new CallWithJedis() {
            @Override
            public void call(Jedis jedis) {
                /*jedis.zadd("lv", 31, "yf");
                jedis.zadd("lv", 32, "xy");*/
                Long lv = jedis.zcard("lv");
                count.setValue(lv);
            }
        });
        System.out.println("count.getValue() = " + count.getValue());
    }

}