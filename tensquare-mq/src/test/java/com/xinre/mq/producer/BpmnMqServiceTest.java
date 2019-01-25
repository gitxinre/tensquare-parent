package com.xinre.mq.producer;

import com.xinre.mq.MqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinre
 * @date 2019/1/18 14:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MqApplication.class)
public class BpmnMqServiceTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {

        Map<String, String> map = new HashMap<>();
        map.put("fl", "lveyf");
        map.put("yf", "lvefl");
        rabbitTemplate.convertAndSend("ly", map);

    }


}