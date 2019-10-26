package com.pingan.rym.zookeeperlocked;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘欣武
 * @version $Id: InterProcessLock, v 0.1 2019/8/24 15:52 刘欣武 Exp$
 */
interface InterProcessLock {

    /**
     * 获取锁、阻塞等待、可重入
     */
    void acquire() throws Exception;

    /**
     * 获取锁、阻塞等待、可重入、超时则获取失败
     */
    boolean acquire(long time, TimeUnit unit) throws Exception;

    /**
     * 释放锁
     */
    void release() throws Exception;

    /**
     * Returns true if the mutex is acquired by a thread in this JVM
     */
    boolean isAcquiredInThisProcess();


}
