package com.org.rabbitmq.controller;

import com.org.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    //队列名称
    public static final String   QUEUE_NAME="test_topic_queues";

    //交换机名称
    public static final String  EXCHANGE_NAME="test_topic_change";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String sendMessage(String message){


        rabbitTemplate.convertAndSend(EXCHANGE_NAME, QUEUE_NAME, message, message1 -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message1.getMessageProperties().setExpiration(1 * 1000 * 60 + "");
            return message1;
        });

        return "我是生产者发送的消息:"+message;
    }
}
