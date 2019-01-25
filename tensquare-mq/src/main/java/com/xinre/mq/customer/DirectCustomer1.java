package com.xinre.mq.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xinre
 * @date 2019/1/18 16:23
 */
@Component
@RabbitListener(queues = {"ly"})
@Slf4j
public class DirectCustomer1 {

    @RabbitHandler
    public void showMenssage(String message) {
        log.info("direct customer1 show message is {}", message);
        System.out.println("direct customer1 show message = " + message);
    }

}
