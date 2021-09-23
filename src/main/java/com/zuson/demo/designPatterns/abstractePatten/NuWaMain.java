package com.zuson.demo.designPatterns.abstractePatten;

public class NuWaMain {

  public static void main(String[] args) {
      YellowManFactory yellowMan = new YellowManFactory();
      Human human = yellowMan.creatYellowMan();
      human.angry();
      human.sex();
  }
}
