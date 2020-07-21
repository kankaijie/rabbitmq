package com.org.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "hello_queue")
public class CancelOrderReceiver {

    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("消息被消费成功");
        LOGGER.info("process orderId:{}",orderId);
        System.out.printf("测试");
    }
}
