package com.zuson.demo.TheadDemo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println(Thread.currentThread().getName()+"=========="+(i+1));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

  public static void main(String[] args) {
        Test1 test1 = new Test1();
      Thread thead = new Thread(test1);
      thead.start();
      int j = 10;
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"============="+j--);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


      BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
  }
}
