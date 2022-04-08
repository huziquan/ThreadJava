package com.company.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseExecutors {
    public static void main(String[] args) {
        Runnable taskOne = () -> System.out.println(Thread.currentThread().getName()+":taskOne");
         //ExecutorService pools = Executors.newCachedThreadPool();
        // ExecutorService pools = Executors.newSingleThreadExecutor();
        ExecutorService pools = Executors.newScheduledThreadPool(10);
       // ExecutorService pools = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 40; i++) {
            pools.submit(taskOne);
        }
    }
}
