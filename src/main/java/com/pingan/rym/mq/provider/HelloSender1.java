package com.pingan.rym.mq.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class HelloSender1 {

    /**

     * AmqpTemplate可以说是RabbitTemplate父类，RabbitTemplate实现类RabbitOperations接口，RabbitOperations继承了AmqpTemplate接口

     */

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate1;

    /**

     * 用于单生产者-》单消费者测试

     */

    public void send() {

        String sendMsg = "hello1 " + LocalDate.now();

        System.out.println("Sender1 : " + sendMsg);

        this.rabbitTemplate1.convertAndSend("helloQueue", sendMsg);

    }

    public void send(String msg) {

        String sendMsg = msg +"  "+ LocalDateTime.now();

        System.out.println("Sender2 : " + sendMsg);

        this.rabbitTemplate.convertAndSend("liuXinWuQueue", sendMsg);

    }

}
