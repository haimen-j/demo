package com.zuson.demo.TheadDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Test6 {

   static AtomicInteger ai = new AtomicInteger(0);

  public static void main(String[] args) {

      new Thread(
              () -> {
                  for (int i = 0; i < 10; i++) {
                      int a = ai.addAndGet(1);
                      System.out.println(Thread.currentThread().getName()+":"+a);
                      try {
                          Thread.sleep(500);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

              })
          .start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                int a = ai.addAndGet(1);
                System.out.println(Thread.currentThread().getName()+":"+a);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

}
