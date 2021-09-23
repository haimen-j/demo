package com.zuson.demo.designPatterns.factoryPatten;

public class BlackMan implements Human {
    @Override
    public void laugh() {
        System.out.println("黑种人笑了。。。");
    }

    @Override
    public void Cry() {
        System.out.println("黑种人哭了。。。");
    }

    @Override
    public void angry() {
        System.out.println("黑种人生气了。。。");
    }
}
