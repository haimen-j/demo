package com.zuson.demo.fanxing;

/**
 * 员工类
 */
public class Employee<e> {

    private Integer id;
    private String name;//名称
    private Integer age;//年龄
    private e gender;//性别

    public Integer getId() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public e getGender() {
        return gender;
    }

    public void setGender(e gender) {
        this.gender = gender;
    }

    public Employee(Integer id, String name, Integer age, e gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
