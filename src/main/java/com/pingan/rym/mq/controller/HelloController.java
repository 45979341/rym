package com.pingan.rym.mq.controller;

import com.pingan.rym.mq.provider.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private HelloSender1 helloSender1;

    /** * 最简单的hello生产和消费实现（单生产者和单消费者） */
    @GetMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    @GetMapping("/hello2")
    public void hello2() {
        helloSender1.send("liuxinwu");
    }



}
