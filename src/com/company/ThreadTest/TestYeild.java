package com.company.ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestYeild {
    private static AtomicInteger T1_COUNT = new AtomicInteger();
    private static AtomicInteger T2_COUNT = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<10000 ; i++) {
                Thread.yield();
                T1_COUNT.getAndAdd(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<10000 ; i++) {
                T2_COUNT.getAndAdd(1);
            }
        });

        t1.start();
        t2.start();
       // t1.join();
        t2.join();
        System.out.println("t1执行了：" + T1_COUNT.get());
        System.out.println("t2执行了：" + T2_COUNT.get());
    }
}
