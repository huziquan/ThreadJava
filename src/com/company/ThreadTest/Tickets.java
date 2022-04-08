package com.company.ThreadTest;

public class Tickets implements Runnable{
  private static Integer COUNT = 100;

  String name;

  public Tickets(String name){
      this.name = name;
  }
//卖票的方法通过关键字  synchronized修饰过后，票的数据正常
  public synchronized static Integer sellTicket(){
      return COUNT--;
  }

    @Override
    public void run() {
        while(Tickets.COUNT>0){
            ThreadUtils.sleep(100);
            System.out.println(name+"出票一张，还剩"+Tickets.sellTicket()+"张！");
        }
    }
    public static void main(String[] args) throws Exception{
      Thread one =new Thread(new Tickets("1号窗口"));
      Thread two = new Thread(new Tickets("2号窗口"));
      one.start();
      two.start();
      Thread.sleep(1000);
    }

}
