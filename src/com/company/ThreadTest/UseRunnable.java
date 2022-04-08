package com.company.ThreadTest;

public class UseRunnable {
    public static void main(String[] args) {
        System.out.println(1);
        //注意，这里new的是Thread
        new Thread(new Task()).start();
        System.out.println(3);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(4);
    }

    static class Task implements Runnable{
        public void run() {
            System.out.println(2);
        }
    }

}
