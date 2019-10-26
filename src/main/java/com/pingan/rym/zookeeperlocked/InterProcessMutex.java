//package com.pingan.rym.zookeeperlocked;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author 刘欣武
// * @version $Id: InterProcessMutex, v 0.1 2019/8/24 16:04 刘欣武 Exp$
// */
//public class InterProcessMutex implements InterProcessLock {
//
//
//    //获取锁
//    public void acquire() throws Exception{
//        if ( !internalLock(-1, null) )
//        {
//            throw new IOException("Lost connection while trying to acquire lock: " + basePath);
//        }
//    }
//    private boolean internalLock(long time, TimeUnit unit) throws Exception
//    {
//        /*
//         实现同一个线程可重入性，如果当前线程已经获得锁，
//         则增加锁数据中lockCount的数量(重入次数)，直接返回成功
//        */
//        //获取当前线程
//        Thread currentThread = Thread.currentThread();
//        //获取当前线程重入锁相关数据
//        LockData lockData = threadData.get(currentThread);
//        if ( lockData != null )
//        {
//            //原子递增一个当前值，记录重入次数，后面锁释放会用到
//            lockData.lockCount.incrementAndGet();
//            return true;
//        }
//        //尝试连接zookeeper获取锁
//        String lockPath = internals.attemptLock(time, unit, getLockNodeBytes());
//        if ( lockPath != null )
//        {
//            //创建可重入锁数据，用于记录当前线程重入次数
//            LockData newLockData = new LockData(currentThread, lockPath);
//            threadData.put(currentThread, newLockData);
//            return true;
//        }
//        //获取锁超时或者zk通信异常返回失败
//        return false;
//    }
//}
//
//
