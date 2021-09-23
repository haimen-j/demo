package com.zuson.demo.designPatterns.multitonPatten;

import java.util.ArrayList;
import java.util.Random;

/**
 * 多例模式：
 *      限定创建的对象
 */
public class Emperor {

    //定义皇帝的数量
    private final static Integer maxEmperorNum = 2;
    //皇帝的名称
    private static ArrayList emperorInfolist = new ArrayList<>(maxEmperorNum);
    //定义皇帝的列表
    private static ArrayList emperorlist = new ArrayList<>(maxEmperorNum);
    //正在被使用的皇帝
    private static Integer useringNum = 0;

    //先把皇帝的名称录入进去
    static {
        for (int i = 0; i < 2; ++i) {
            emperorlist.add(new Emperor("皇"+i+"帝"));
        }
    }
    private Emperor(String name){
        emperorInfolist.add(name);
    }

    private Emperor(){};

    public static  Emperor getInstance(){
        Random random = new Random();
        useringNum = random.nextInt(maxEmperorNum);
        return (Emperor)emperorlist.get(useringNum);
    }

    /**
     * 指定参拜的皇帝
     * @param useringNum
     * @return
     */
    public static  Emperor getInstance(Integer emperorNum){
        useringNum = emperorNum;
        return (Emperor)emperorlist.get(useringNum);
    }

    public static void  emperorInfo(){
        System.out.println(emperorInfolist.get(useringNum));
    }


}
