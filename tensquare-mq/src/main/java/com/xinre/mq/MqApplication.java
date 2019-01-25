package com.xinre.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xinre
 * @date 2019/1/18 14:43
 */
@SpringBootApplication
public class MqApplication {


    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

    /*@Bean
    public Queue wfQueue() {
        return new Queue("ly");
    }*/

}
