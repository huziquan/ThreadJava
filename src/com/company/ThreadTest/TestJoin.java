package com.company.ThreadTest;

public class TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<10 ; i++) {
                ThreadUtils.sleep(10);
                System.out.println("这是线程1-----"+i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<100 ; i++) {
                ThreadUtils.sleep(10);
                System.out.println("这是线程2-----"+i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------");
    }
}
