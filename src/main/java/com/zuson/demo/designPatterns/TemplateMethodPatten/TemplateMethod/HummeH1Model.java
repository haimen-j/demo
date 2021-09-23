package com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod;

public class HummeH1Model extends HummeModel {

    private Boolean alarmStatus;

    @Override
    protected void start() {
        System.out.println("悍马1开始点火。。。");
    }

    @Override
    protected void stop() {
        System.out.println("悍马1关闭车。。。");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马1发动机开始工作。。。");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马1喇叭开始响起。。滴滴。。");
    }

    @Override
    public boolean isStartAlarm() {
        return this.alarmStatus;
    }


    public void setAlarmStatus(Boolean alarmStatus){
        if (alarmStatus) System.out.println("打开喇叭。。。");
        else System.out.println("关闭喇叭。。。");
        this.alarmStatus = alarmStatus;
    }

}
