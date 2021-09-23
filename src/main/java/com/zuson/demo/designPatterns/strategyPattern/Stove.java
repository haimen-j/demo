package com.zuson.demo.designPatterns.strategyPattern;

/**
 * 做饭的炉子
 */
public class Stove {

    private IPot iPot;

    public Stove(IPot iPot){
        this.iPot = iPot;
    }

    public void startCook(){
        iPot.importFood();
    }

}
