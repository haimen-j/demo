package com.zuson.demo.designPatterns.abstractePatten;

public  abstract class YellowMan implements Human {

    public void laugh() {
        System.out.println("抽象类：黄种人笑了。。。。");
    }

    public void Cry() {
        System.out.println("抽象类：黄种人哭了。。。");
    }

    public void angry() {
        System.out.println("抽象类：黄种人生气了。。。");
    }
}
