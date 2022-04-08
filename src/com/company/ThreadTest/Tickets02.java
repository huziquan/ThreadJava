package com.company.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class Tickets02 implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock();
    private static Integer COUNT = 100;

    String name;

    public Tickets02(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (Tickets02.COUNT > 0) {
            ThreadUtils.sleep(100);
            // 就在这里
            lock.lock();
            try {
                System.out.println(name + "出票一张，还剩" + Tickets02.COUNT-- + "张！");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new Tickets02("一号窗口"));
        Thread two = new Thread(new Tickets02("二号窗口"));
        one.start();
        two.start();
        Thread.sleep(10000);
    }
}
