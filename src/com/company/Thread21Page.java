package com.company;


/*
* 　　当INSTANCE没有volatile修饰　会出现的问题
* 第一个线程 判断INSTANCE为空的时候，进入了Syn然后停下来
* 第二个线程 运行，但此时第一个线程INSTANCE还未实例化，所以INSTANCE=null，第二个线程等待第一个线程释放所
* 第一个线程，运行释放了锁，但此时INSTANCE 已经实例化，但第二个线程不知道，
* 第二个线程开始运行，他没有对INSTANCE检查，直接NEW产生了一个新的对象；（地址会有所变化）
* */
public class Thread21Page {
    private /*volatile*/ static Thread21Page INSTANCE;
    private Thread21Page(){
    }
    public static Thread21Page getInstance(){
        if(INSTANCE == null){
            synchronized (Thread21Page.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Thread21Page();
            }
        }
        return INSTANCE;
    }
    public static void m(){System.out.println(")-(");
    }
    public static void main(String[] args){
       for(int i=0;i<100;i++){
           new Thread(()-> {
               System.out.println(Thread21Page.getInstance().hashCode());
           }).start();
       }
    }
}
