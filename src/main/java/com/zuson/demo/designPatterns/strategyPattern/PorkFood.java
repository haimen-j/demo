package com.zuson.demo.designPatterns.strategyPattern;

public class PorkFood implements IPot {
    @Override
    public void importFood() {
        System.out.println("开始加功猪肉。。。");
    }
}
