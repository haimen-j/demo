package com.zuson.demo.designPatterns.factoryPatten;

public class WhiteMan implements Human {
    @Override
    public void laugh() {
        System.out.println("白种人笑了。。。");
    }

    @Override
    public void Cry() {
        System.out.println("白种人哭了。。。");
    }

    @Override
    public void angry() {
        System.out.println("白种人生气了。。。");
    }
}
