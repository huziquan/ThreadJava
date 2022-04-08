package com.company.ThreadTest;

public class VolaTest {
    private  static boolean isOver = false;//没有volatile时，线程一直在循环
    //private  volatile static boolean isOver = false;
    private static int number = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!isOver) {
            }
            System.out.println(number);
        });
        thread.start();
        Thread.sleep(1000);
        number = 50;
        // 已经改了啊，应该可以退出上边循环的值了啊！
        isOver = true;
    }
}
