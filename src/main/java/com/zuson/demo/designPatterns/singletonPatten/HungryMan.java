package com.zuson.demo.designPatterns.singletonPatten;

/**
 * 单例模式：
 *      饿汉式
 */
public class HungryMan {

    static final HungryMan man = new HungryMan();

    private HungryMan(){};

    public static HungryMan getInstence(){
        return man;
    }

}
