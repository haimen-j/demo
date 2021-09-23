package com.zuson.demo.TheadDemo;

import org.apache.poi.ss.formula.functions.T;

/**
 * 写一个程序模拟死锁
 * 同时两个线程，A有自己的资源但A不释放自己的资源而且想要占用B的资源，
 * B有自己的资源但B不释放自己的资源而且B想要占用A的资源
 */
public class Test3 {
    Object a = new Object();
    Object b = new Object();
    void ma () {
      synchronized (a){
          System.out.println(Thread.currentThread().getName() + "------get lock a");
          mb();
      }
    }
    void mb () {
      synchronized (b){
          System.out.println(Thread.currentThread().getName() + "------get lock b");
          ma();
      }
    }

  public static void main(String[] args) {
        Test3 t3 = new Test3();
    /*new Thread(
    () -> {
        t3.ma();
    }).start();*/
    Thread thread =
        new Thread(
            () -> {
              System.out.println("进入了方法！");
             /* try {
                  Thread.sleep(Integer.MAX_VALUE);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }*/
            });
      thread.start();

      Thread.State state = thread.getState();
    System.out.println("aa"+thread.isAlive());
  }
}
