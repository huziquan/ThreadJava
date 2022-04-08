package com.company.ThreadTest;

public class UseThread {
    public static void main(String[] args) {
        new MyTask().start();
        System.out.println(1);
        System.out.println(3);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(4);
    }

    static class MyTask extends Thread{
        @Override
        public void run() {
            System.out.println(2);
        }
    }
}
