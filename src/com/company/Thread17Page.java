package com.company;

import java.util.concurrent.TimeUnit;

public class Thread17Page {
    volatile boolean running = true;
    int i = 0;
    void m(){
        System.out.println("Starting");
        while(running){
            i++;
        }
        System.out.println( "End:"+i);
    }

    public static void main(String[] args){
        Thread17Page t = new Thread17Page();
        new Thread(t::m,"TMax").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
