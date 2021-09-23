package com.zuson.demo.designPatterns.FacadePattern;

/**
 * 写信代办人员
 */
public class ModePostOffice {

    public static void sendLetter(String context,String address){
        LetterProcess lp = new LetterProcessImpl();
        PoliceOffice policeOffice = new PoliceOffice();
        lp.writeContext(context);
        lp.fileEnveple(address);
        //检查信封
        policeOffice.checkLetter(lp);
        lp.letterIntoEnveple();
        lp.sendLetter();
    }

}
