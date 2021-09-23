package com.zuson.demo.designPatterns.FacadePattern;

/**
 * 写信的过程
 */
public interface LetterProcess {

    //写信
    public void writeContext(String context);
    //写信封
    public void fileEnveple(String address);

    //把新放在信封里
    public void letterIntoEnveple();

    //把信发出去
    public void sendLetter();

    public String getContext();

    public String getAddress();
}
