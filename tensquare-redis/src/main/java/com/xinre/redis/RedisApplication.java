package com.xinre.redis;

import com.xinre.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinre
 * @date 2019/1/24 09:26
 */
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Bean
    public JedisCluster getJedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.100.109", 3791));
        nodes.add(new HostAndPort("192.168.100.109", 3792));
        nodes.add(new HostAndPort("192.168.100.109", 3793));
        nodes.add(new HostAndPort("192.168.100.109", 3797));
        return new JedisCluster(nodes);
    }

    @Bean
    public JedisPool getJedisPool() {
        return new JedisPool("127.0.0.1", 6379);
    }

    @Bean
    public IdWorker getIdWork() {
        return new IdWorker();
    }


}
