package com.company.ThreadTest;

public class OutOfOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;
    private static int count = 0;

    private static volatile int NUM = 0;

    public static void main(String[] args)
            throws InterruptedException {
        long start = System.currentTimeMillis();
        while(true) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("一共执行了：" + (count++) + "次"+"，(" + x + "," + y + ")");
            if(x==1 && y==1){
                long end = System.currentTimeMillis();
                System.out.println("耗时：+"+ (end-start) +"毫秒，(" + x + "," + y + ")");
                break;
            }
            a=0;b=0;x=0;y=0;
        }
    }
}
