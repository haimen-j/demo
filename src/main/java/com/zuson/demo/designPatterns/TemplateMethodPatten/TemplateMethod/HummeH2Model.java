package com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod;

public class HummeH2Model extends HummeModel {
    @Override
    protected void start() {
    System.out.println("悍马2开始点火。。。");
    }

    @Override
    protected void stop() {
    System.out.println("悍马2关闭车。。。");
    }

    @Override
    protected void engineBoom() {
    System.out.println("悍马2发动机开始工作。。。");
    }

    @Override
    protected void alarm() {
    System.out.println("悍马2喇叭开始响起。。滴滴。。");
    }

    @Override
    protected boolean isStartAlarm() {
        return false;
    }

    @Override
    public void setAlarmStatus(Boolean alarmStatus) {

    }
}
