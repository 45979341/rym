/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2018/7/30 0030
 * Time: 下午 10:04
 */
package com.pingan.rym.thread;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;

public class Service {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    //DistributedLock lock = new DistributedLock(pool);

    int n = 500;

    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        //String indentifier = lock.lockWithTimeout("resource", 5000, 1000);
        String requestId = UUID.randomUUID().toString();
        Jedis jedis = pool.getResource();
        RedisTool.tryGetDistributedLock(jedis,"lockey",requestId,3000);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        jedis.set("n值",n+"");
        //lock.releaseLock("resource", indentifier);
        RedisTool.releaseDistributedLock(jedis, "lockey", requestId);
    }
}