package com.zuson.demo.designPatterns.strategyPattern;

/**
 * 策略模式：
 *  一个类的行为和算法可以在运行时改变
 *  优点：
 *      算法可以自由切换，扩展性好
 *  缺点：
 *      策略类会增多，所有策略类都需要对外暴露
 */
public class ChiefMain {

  public static void main(String[] args) {
    // 将锅里的食物放在炉子上，厨师开始烹饪！
      System.out.println("第一步--------");
      Stove fish = new Stove(new FishFood());
      fish.startCook();
      System.out.println("第二步--------");
      Stove pork = new Stove(new PorkFood());
      pork.startCook();
      System.out.println("第三步--------");
      Stove vegetables = new Stove(new VegetablesFood());
      vegetables.startCook();
  }
}
