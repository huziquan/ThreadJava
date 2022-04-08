package com.company.ThreadTest;
/*
* ThreadLocal  各自线程有各自的变量，互不影响。
* */
public class TestThreadLocal {
    private final static ThreadLocal<Integer> number = new ThreadLocal<>();
    public static final int COUNT = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                number.set(COUNT);
                for (int i = 0; i < 1000; i++) {
                    number.set(number.get() + 1);
                    System.out.println("t1----:" + number.get());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                number.set(COUNT);
                for (int i = 0; i < 1000; i++) {
                    number.set(number.get() + 1);
                    System.out.println("t2----:" + number.get());
                }
            }
        });
        t1.start();
        t2.start();
    }
}
