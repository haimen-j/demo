package com.zuson.demo.TheadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test4 {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);
    Test4 t = new Test4();
    new Thread(
        () -> {
          System.out.println("t2 启动了！");
          int size = t.size();
          if (size != 5) {
            try {
              latch.await();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("t2 执行结束！");
            latch2.countDown();
        },"t2").start();

    new Thread(
            () -> {
              System.out.println("t1 启动了");
              for (int i = 0; i < 10; i++) {
                t.add(new Object());
                if (t.size()==5){
                    latch.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                  System.out.println(i);
                 /* try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }*/
              }
              System.out.println("t1 执行结束！");
            },
            "t1")
        .start();
  }
}
