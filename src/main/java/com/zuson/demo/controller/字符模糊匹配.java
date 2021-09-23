package com.zuson.demo.controller;

public class 字符模糊匹配 {

  public static void main(String[] args) {
      /***
       * 英文
       */
      String abc1 = "百度科技(123)公司1";
      abc1 = abc1.replaceAll("\\(", "（").replaceAll("\\)","）");
      System.out.println(abc1);

/**
 * 中文
 */
      String abc2 = "百度科技（123）公司2";
      abc2 = abc2.replaceAll("（","").replaceAll("）","");
      System.out.println(abc2);
  }
}
