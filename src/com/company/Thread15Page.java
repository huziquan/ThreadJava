package com.company;

import java.util.concurrent.TimeUnit;

public class Thread15Page {
    int count = 0;
    synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+"start");
        while(true){
            count++;
            System.out.println(Thread.currentThread().getName()+" count"+count);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*try {*/
                if (count == 6) {
                    int n = count / 0;
                    System.out.println(n);
                }
           /* }catch (Exception e){
                System.out.println(e.getCause());
            }*/
        }
    }

    public static void main(String[] args){
        Thread15Page t= new Thread15Page();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        };
        new Thread(r,"Thread15").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"thred2").start();
    }
}
