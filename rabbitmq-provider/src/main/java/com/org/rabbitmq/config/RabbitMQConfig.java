package com.org.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitMQConfig {

    //队列名称
    public static final String   QUEUE_NAME="test_topic_queues";

    //交换机名称
    public static final String  EXCHANGE_NAME="test_topic_change";


    /***
     * 声明队列
     * @return
     */
    @Bean
    public Queue createQueue(){
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", QUEUE_NAME);
        return new Queue(QUEUE_NAME,true,false,false,params);
    }


    /***
     * 申明交换机
     * @return
     */
    @Bean
    public TopicExchange  createTopExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }




    /***
     * 把队列绑定到交换机上
     * @param
     * @return
     */
    @Bean
    public Binding smsQueueTopicExchangeBinding(){
        return BindingBuilder.bind(createQueue()).to(createTopExchange()).with(QUEUE_NAME);
    }



}
