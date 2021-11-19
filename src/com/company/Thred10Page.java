package com.company;

public class Thred10Page  implements  Runnable{

  private int count = 100;

    @Override
    public synchronized void  run() {
     count--;
     System.out.println(Thread.currentThread().getName() + "count = " +count);
    }

    public static void main(String[] args){
        Thred10Page t = new Thred10Page();
        for(int i = 0;i<100;i++){
            new Thread(t,"THREAD"+i).start();
        }
    }
}
