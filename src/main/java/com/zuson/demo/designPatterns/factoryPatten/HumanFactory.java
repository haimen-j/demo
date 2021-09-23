package com.zuson.demo.designPatterns.factoryPatten;

/**
 * 人类工厂
 */
public class HumanFactory {

    public static Human createMan(Class c){
        Human human = null;
        try {
            human = (Human)Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("没找到此对象");
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("实例化对象失败。。。");
        }
        return human;
    }

}
