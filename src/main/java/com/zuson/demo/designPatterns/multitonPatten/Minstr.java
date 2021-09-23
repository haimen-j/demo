package com.zuson.demo.designPatterns.multitonPatten;

public class Minstr {

  public static void main(String[] args) {
    for (int i = 0; i < 10 ;i++) {
        Emperor emperor = Emperor.getInstance();
        System.out.println(emperor.hashCode());
    }
  }
}
