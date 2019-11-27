package com.pingan.rym.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "liuXinWuQueue")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {

        System.out.println("Receiver2  : " + hello);


    }
}
