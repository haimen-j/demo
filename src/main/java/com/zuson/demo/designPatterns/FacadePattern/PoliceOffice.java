package com.zuson.demo.designPatterns.FacadePattern;

public class PoliceOffice {

    public void checkLetter(LetterProcess letterProcess){
        System.out.println("----------------------开始检查信的内容--------------");
        System.out.println("查看信的内容是："+letterProcess.getContext());
        System.out.println("查看信的地址是："+letterProcess.getAddress());
        System.out.println("----------------------信的内容检查完毕--------------");
    }

}
