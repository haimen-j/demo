package com.zuson.demo.designPatterns.singletonPatten;

/**
 * 单例模式：
 *      双重锁
 *      优点：解决了懒汉式中的线程安全问题
 *      缺点：代码实现起来比较负责
 *      在实际的工作中，饿汉式是最简单而且最安全的一种方式，推荐使用。
 */
public class DoubleLock {

    static DoubleLock doubleLock = null;

    private DoubleLock (){};

    public static  DoubleLock getinstance(){
        if (doubleLock==null){
            synchronized(DoubleLock.class){
                if (doubleLock==null){
                    doubleLock = new DoubleLock();
                }
            }
        }
        return doubleLock;
    }

  public static void main(String[] args) {
      for (int i = 0; i < 100; i++) {
          new Thread(()->{
              System.out.println(DoubleLock.getinstance().hashCode());
          }).start();

      }
  }
}
