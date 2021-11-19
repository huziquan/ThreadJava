package com.company;

public class Thread20Page02 {
    private static Thread20Page02 INSTANCE;
    private Thread20Page02(){

    }

    public static synchronized Thread20Page02 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Thread20Page02();
        }
        return INSTANCE;
    }

    public void m(){System.out.println("Thread ...");}

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Thread20Page02.getInstance().hashCode());
            }).start();
        }
    }
}
