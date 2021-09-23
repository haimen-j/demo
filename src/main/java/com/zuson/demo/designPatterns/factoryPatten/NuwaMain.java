package com.zuson.demo.designPatterns.factoryPatten;

public class NuwaMain {

  public static void main(String[] args) {
      Human man = HumanFactory.createMan(BlackMan.class);
      man.Cry();
      man.laugh();
      man.angry();
  }
}
