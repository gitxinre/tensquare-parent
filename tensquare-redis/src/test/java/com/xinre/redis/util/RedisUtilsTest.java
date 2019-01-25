package com.xinre.redis.util;

import com.xinre.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

/**
 * @author xinre
 * @date 2019/1/24 10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisUtilsTest {

    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testPf() {

        for (int i = 0; i < 100000; i++) {
            jedisCluster.pfadd("codehole", "user" + i);
            long totle = jedisCluster.pfcount("codehole");
            System.out.println("i = " + i);
            System.out.println("fen totle = " + totle);

            /*if (totle != i + 1) {
                System.out.println("totle = " + totle + " || i = " + i);
                break;
            }*/
        }
        long codehole = jedisCluster.pfcount("codehole");
        System.out.println("totle = " + codehole);


    }

    @Test
    public void testJedisXianliu() {

        Jedis jedis = jedisPool.getResource();

        Pipeline pipelined = jedis.pipelined();
        Object obj = new Object();
        obj.toString();
    }


}