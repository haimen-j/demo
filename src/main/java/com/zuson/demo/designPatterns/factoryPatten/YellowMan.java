package com.zuson.demo.designPatterns.factoryPatten;

/**
 * 黄种人
 */
public class YellowMan implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人笑了。。。。");
    }

    @Override
    public void Cry() {
        System.out.println("黄种人哭了。。。");
    }

    @Override
    public void angry() {
        System.out.println("黄种人生气了。。。");
    }
}
