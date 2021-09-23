package com.zuson.demo.TheadDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test7 {

  public static void main(String[] args) {

      theadFunction(1);
      theadFunction1(1);
  }

  public static void theadFunction(int a){
      ExecutorService service = Executors.newSingleThreadExecutor();
      service.execute(
        new Runnable() {
          @Override
          public void run() {
            for (int i = 0; i < 10; i++) {
              System.out.println(Thread.currentThread().getName()+":"+(a+i));
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
          }
        });
      service.shutdown();
  }
  public static void theadFunction1(int a){
      for (int i = 0; i < 10; i++) {
          System.out.println(Thread.currentThread().getName()+":"+(a+i));
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

      }
  }
}
