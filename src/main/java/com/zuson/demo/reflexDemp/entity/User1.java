package com.zuson.demo.reflexDemp.entity;

import java.util.Date;

public class User1 {

    private Integer id;
    private String name;
    private Integer sex;
    private Date time;

    public Integer getId() {
        System.out.println("方法调用成功");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User1() {
    }

    public User1(Integer id, String name, Integer sex, Date time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.time = time;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", time=" + time +
                '}';
    }
}
