package com.company.ThreadTest;

public class MainTest {
    //volatile
    private static  int COUNT = 0;

    //synchronized
    public  synchronized static void adder(){
        COUNT++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("最后的结果是："+COUNT);
    }
}
