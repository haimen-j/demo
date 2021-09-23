package com.zuson.demo.designPatterns.proxyPattern;

/**
 * 代理模式：
 *      代理模式是一个类代表另一个类的功能，但是A知识B类的代理类，AB之间具有相同的功能，A只负责B的代理
 *      具体干活的是B
 *      优点：
 *          职责清晰，高扩展性，智能化。
 *      缺点：
 *          1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
 *          2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
 */
public class DaoyanMain {

  public static void main(String[] args) {
      //导演要王宝强工作
      Songji songji = new Songji();
      songji.canActing();
      songji.canSing();
      //导演找成龙工作
      Songji cheng = new Songji(new Chenglong());
      cheng.canActing();
      cheng.canSing();
  }
}
