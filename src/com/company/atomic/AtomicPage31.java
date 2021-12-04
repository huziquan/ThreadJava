package com.company.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
/*
* Atomic 没有加锁
* syn 有可能会申请系统的锁，所以会比较慢
* LongAdder  会比Atomic快一点点  有一个类似分段锁的概念
*
*分段锁：没看懂抽时间还得学习
* */
public class AtomicPage31 {
    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong(0L);
    static LongAdder count3 =new LongAdder();


    public static void  main(String[] args)throws Exception{

        // ------------------------------------------------------atomic   count1
        Thread[] threads = new Thread[1000];
        for(int i=0;i<threads.length;i++){
            threads[i]= new Thread(()->{
               for(int n=0;n<100000;n++){
                   count1.incrementAndGet();
               }
            });
        }
        long start =System.currentTimeMillis();
        for(Thread t:threads) t.start();
        for(Thread t:threads) t.join();
        long end = System.currentTimeMillis();
            System.out.println("Atomic的值为："+count1.get()+",花费的时间为："+(end-start));
        //-----------------------------------------------------------普通的 count2
        Object lock2 = new Object();
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int n=0;n<100000;n++){
                        synchronized (lock2){
                            count2++;
                        }
                    }
                }
            });
        }
        start = System.currentTimeMillis();
        for(Thread t:threads) t.start();
        for(Thread t:threads) t.join();
        end = System.currentTimeMillis();
        System.out.println("普通加锁syn得到的值："+count2+",花费的时间;"+(end-start));
        //-------------------------------------------------------Longadder 测试
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(()->{
               for(int n=0;n<100000;n++) count3.increment();
            });
        }

        start= System.currentTimeMillis();
        for(Thread t:threads) t.start();
        for(Thread t:threads) t.join();
        end=System.currentTimeMillis();
        System.out.println("LongAdder的最终值："+count3.longValue()+",花费的时间为："+(end-start));
    }
    static  void microsleep(int m){
        try {
            TimeUnit.MICROSECONDS.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
