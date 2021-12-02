package com.company;
/*
* 最终测试效果，不管方法 m() 有没有syn最终的count结果都为100000,和书中的内容不一样
* */
import java.util.ArrayList;
import java.util.List;

public class Thread23Page {
     volatile int count = 0;
     /*synchronized*/ void m(){
         for(int i=0;i<10000;i++){
             count++;
         }
     }

     public static void main(String[] args){
         Thread23Page t =new Thread23Page();

         List<Thread> list = new ArrayList<>();
         for(int i=0;i<10;i++){
             list.forEach((o)->{
                 try {
                     o.join();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             });
             t.m();
             System.out.println(t.count);
         }
     }
}
