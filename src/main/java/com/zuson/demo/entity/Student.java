package com.zuson.demo.entity;

public class Student {

    private String name;
    private Integer pm25;
    private Integer pm10;
    private Integer so2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getSo2() {
        return so2;
    }

    public void setSo2(Integer so2) {
        this.so2 = so2;
    }

    public Student(String name, Integer pm25, Integer pm10, Integer so2) {
        this.name = name;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.so2 = so2;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", so2=" + so2 +
                '}';
    }
}
