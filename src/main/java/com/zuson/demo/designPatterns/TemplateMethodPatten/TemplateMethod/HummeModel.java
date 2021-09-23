package com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod;

import java.lang.reflect.AccessibleObject;

public abstract class HummeModel {


    //开
    protected abstract void start();
    //停
    protected abstract void stop();
    //发动机
    protected abstract void engineBoom();
    //喇叭
    protected abstract void alarm();
    //喇叭开关
    protected abstract boolean isStartAlarm();
    //
    public abstract void setAlarmStatus(Boolean alarmStatus);
    //跑
    final public void run(){
        this.start();
        this.engineBoom();
        if (this.isStartAlarm()){
            this.alarm();
        }
        this.stop();
    };

}
