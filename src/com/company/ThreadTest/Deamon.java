package com.company.ThreadTest;

/*
* 守护线程
* */
public class Deamon {
    public static void main(String[] args){

        Thread t1 = new Thread(()->{
            int count = 10;
            Thread t2 = new Thread(()->{
                while(true){
                    ThreadUtils.sleep(300);
                    System.out.println("守护线程！");
                }
            });
            t2.setDaemon(true);
            t2.start();

            /*   */
            while(count>=0){
                ThreadUtils.sleep(300);
                System.out.println("用户线程："+count);
                count--;
            }
            System.out.println("用户线程结束=========");
        });
        System.out.println("Main函数执行");

        //t1.setDaemon(true); //
        t1.start();
        System.out.println("Main函数结束");
    }
}
