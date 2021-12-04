package com.company.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/*
* join() 该方法很重要，在没有该方法，得到最终的结果是不一样的，
* o.join（） 目的是，在对象o完成后才能运行(main函数)主线程，改程序中，总共10个线程通过forEach来循环,
* */


public class AtomicPage29 {
   AtomicInteger count = new AtomicInteger(0);
   /* volatile int count = 0;*/
   /*synchronized*/ void m(){
       for(int i=0;i<10000;i++){
           count.incrementAndGet();
          /* count++;*/
       }
   }
   public static void main(String [] args){

       AtomicPage29 t=new AtomicPage29();

       List<Thread> threads =new ArrayList<>();
       for(int i=0;i<10;i++){
           threads.add(new Thread(t::m,"thread"+i));
       }
       threads.forEach(o->o.start());

       threads.forEach(o->{
           try {
               o.join();
               System.out.println(o.getName());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
       System.out.println(t.count);
   }
}
