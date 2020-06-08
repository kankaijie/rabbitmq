package com.org.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyMoonitor {


    /***
     * 监听队列并且消费
     */
    @RabbitListener(queues = "test_topic_queues")
    public void  consumersMessage(String message){
        System.out.println("====我是消费者消费了==="+message);
    }
}
