package com.company.ThreadTest;
/*
* 使用interrupt()方法中断线程（只有线程在wait和sleep才会捕获InterruptedException异常，执行终止线程的逻辑，在运行while(true)中不会捕获）
* */
public class TreadInterrupt extends Thread{
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            synchronized (this) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    this.stopThread();
//                }

                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.stopThread();
                }
            }
        }
    }

    public void stopThread() {
        System.out.println("线程已经退出。。。");
        this.flag = false;
    }
}

 class StopThreadDemo02 {

    public static void main(String[] args) {
        TreadInterrupt thread02 = new TreadInterrupt();
        thread02.start();
        System.out.println("线程开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread02.interrupt();
    }
}