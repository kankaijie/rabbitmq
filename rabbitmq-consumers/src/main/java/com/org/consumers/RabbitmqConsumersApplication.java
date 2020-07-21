package com.org.consumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumersApplication.class, args);
        System.out.println("==========我是消费者启动=======");
        System.out.printf("天青色等烟雨");
    }


}
