package com.zuson.demo.designPatterns.strategyPattern;

public class FishFood implements IPot {
    @Override
    public void importFood() {
        System.out.println("开始加功鱼肉。。。。");
    }
}
