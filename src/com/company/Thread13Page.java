package com.company;

import java.util.concurrent.TimeUnit;

public class Thread13Page {
/*
* 线程的可重入问题，当一个同步方法内部调用另一个同步方法（同一个线程）
* */

synchronized void m1(){
    System.out.println("m1 start");
    try {
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    m2();
    System.out.println("m1 end");
}

synchronized  void m2(){
    try {
        TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("m2");
}

public static void main(String[] args){
    Thread13Page t = new Thread13Page();

    new Thread(t::m1,"T1").start();
}
}
