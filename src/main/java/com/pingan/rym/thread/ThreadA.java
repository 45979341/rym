/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2018/7/30 0030
 * Time: 下午 10:12
 */
package com.pingan.rym.thread;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}