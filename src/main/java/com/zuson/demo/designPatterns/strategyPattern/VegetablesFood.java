package com.zuson.demo.designPatterns.strategyPattern;

public class VegetablesFood implements IPot {
    @Override
    public void importFood() {
        System.out.println("开始烹饪蔬菜。。。");
    }
}
