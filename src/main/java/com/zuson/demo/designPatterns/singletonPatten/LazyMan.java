package com.zuson.demo.designPatterns.singletonPatten;

/**
 * 单例模式：
 *      懒汉式
 *      优点：只有被调用的时候才会初始化对象
 *      缺点：多线程并发下会带来问题
 */
public class LazyMan {

    static LazyMan  lazy = null;

    private LazyMan(){};

    public static LazyMan getInstance(){
        if (lazy==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazy = new LazyMan();
        }
        return lazy;
    }

  public static void main(String[] args) {
      for (int i = 0; i < 100; i++) {
          new Thread(()->{
              LazyMan lazyMan = LazyMan.getInstance();
              System.out.println(lazyMan.hashCode());
          }).start();

      }
  }
}
