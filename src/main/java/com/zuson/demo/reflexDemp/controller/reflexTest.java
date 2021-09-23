package com.zuson.demo.reflexDemp.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflexTest {

    public static void main(String[] args) throws Exception{
        //获得Person的Class对象
        Class<?> cls = Person.class;//Class.forName("testJavaSE.Person");
        Constructor con = cls.getDeclaredConstructor();
        System.out.println("得到了Person的构造函数");
        //创建Person实例
        Person p = (Person) con.newInstance();
        System.out.println("创建了一个person对象");
        //获得Person的Method对象,参数为方法名,参数列表的类型Class对象
        Method method = cls.getDeclaredMethod("eat", String.class);
        System.out.println("得到了Person的eat方法");
        //invoke方法，参数为Person实例对象，和想要调用的方法参数
        String value = (String) method.invoke(p, "肉");

        Method method1 = cls.getDeclaredMethod("getInfo");

        String value1 = (String) method1.invoke(p);
        //输出invoke方法的返回值
        System.out.println("eat方法的返回值：" + value);
        System.out.println("eat方法的返回值：" + value1);
    }
    static class Person{

        private String info;

        public  String  eat(String food) {
            System.out.println("吃"+food);
            this.info = "吃"+food;
            return "返回值";
        }
        public  String  getInfo() {
            return info;
        }

    }

}
