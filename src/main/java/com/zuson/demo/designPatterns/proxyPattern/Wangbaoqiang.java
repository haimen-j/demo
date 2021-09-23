package com.zuson.demo.designPatterns.proxyPattern;

public class Wangbaoqiang implements KindMan {
    @Override
    public void canActing() {
        System.out.println("王宝强可以演戏。。。");
    }

    @Override
    public void canSing() {
        System.out.println("王宝强可以唱歌。。。");
    }
}
