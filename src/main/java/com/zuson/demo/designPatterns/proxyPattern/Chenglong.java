package com.zuson.demo.designPatterns.proxyPattern;

public class Chenglong implements KindMan {
    @Override
    public void canActing() {
        System.out.println("成龙可以演戏。。。");
    }

    @Override
    public void canSing() {
        System.out.println("成龙可以唱歌。。。");
    }
}
