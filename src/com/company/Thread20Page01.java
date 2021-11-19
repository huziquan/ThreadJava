package com.company;

public class Thread20Page01 {
    private  static  Thread20Page01 INSTANCE;

    private  Thread20Page01(){
    }

    public static Thread20Page01 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Thread20Page01();
        }
        return  INSTANCE;
    }

    public  void m(){ System.out.println("Thread ...");}

    public static void main(String[] args){
        for(int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println("第+个："+Thread20Page01.getInstance().hashCode());
            }).start();
        }
    }
}

