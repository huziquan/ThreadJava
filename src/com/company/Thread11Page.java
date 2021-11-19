package com.company;
//同步方法 和非同步方法是否可以同时运行
public class Thread11Page {

    private  int count = 100;
    public  synchronized void m1(){
     System.out.println(Thread.currentThread().getName()+ "m1  start...");
      try{
           count++;
           Thread.sleep(10000);

      } catch (InterruptedException e){
          e.printStackTrace();
      }
     System.out.println(Thread.currentThread().getName()+" m1  end:"+count);
    }

    public   void  m2(){
        try {
            Thread.sleep(5000);
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "m2 :"+ count);
    }

    public static void main(String[] args){
        Thread11Page t = new Thread11Page();
        new Thread(t::m1,"Tmax1").start();
        new Thread(t::m2,"Tmin2").start();
    }
}
