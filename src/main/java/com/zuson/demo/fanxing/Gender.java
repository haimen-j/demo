package com.zuson.demo.fanxing;

public enum Gender {

    男(1),女(2);

    private Integer sex;

    Gender(Integer sex) {
        this.sex = sex;
    }

    Gender() {
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer show(){
        return Gender.男.getSex();
    }
}
