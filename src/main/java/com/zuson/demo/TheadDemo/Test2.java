package com.zuson.demo.TheadDemo;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;

import java.util.concurrent.TimeUnit;

/**
 * 多线程
 * A线程正在执行一个对象中的同步方法，
 * B线程是否可以同时执行同一个对象中的非同步方法？
 */
public class Test2 {
    public synchronized  void ma(Integer type){
        System.out.println(Thread.currentThread().getName()+ "ma 开始执行。。。");
        if (type==1){
            int b = 3/0;
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"ma 执行结束。。。");
    }

    public  void mb (){
        System.out.println(Thread.currentThread().getName()+"mb 执行。。。");
    }

  public static void main(String[] args) {
      Test2 t = new Test2();
        Thread t1 = new Thread(() ->{t.ma(1);});
        System.out.println(t1.getName()+"开始执行");
        t1.start();
      Thread t2 = new Thread(() ->{t.ma(0);});
      System.out.println(t2.getName()+"开始执行");
      t2.start();
  }
}
