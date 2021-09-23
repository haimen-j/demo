package com.zuson.demo.designPatterns.FacadePattern;

public class LetterProcessImpl implements LetterProcess {

    public static String context;
    public static String address;

    @Override
    public void writeContext(String context) {
        this.context = context;
        System.out.println(context);
    }

    @Override
    public void fileEnveple(String address) {
        this.address = address;
        System.out.println(address);
    }

    @Override
    public void letterIntoEnveple() {
        System.out.println("信已经装在了信封里了。。。");
    }

    @Override
    public void sendLetter() {
        System.out.println("信件正在发送中。。。");
    }

    @Override
    public String getContext() {
        return this.context;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
