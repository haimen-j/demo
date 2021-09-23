package com.zuson.demo.designPatterns.abstractePatten;

public class YellowManFactory extends AbstractYellowManFactory {

    public Human creatYellowMan(){
        return super.createHuman("com.zuson.demo.designPatterns.abstractePatten.MaleYellowMan");
    }

}
