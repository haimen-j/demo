package com.zuson.demo.fanxing;

/**
 * 程序员类
 */
public class SE<e> extends Employee<e>{

    private Integer workOfYear;

    public Integer getWorkOfYear() {
        return workOfYear;
    }

    public void setWorkOfYear(Integer workOfYear) {
        this.workOfYear = workOfYear;
    }

    public SE(Integer id, String name, Integer age, e gender, Integer workOfYear) {
        super(id, name, age, gender);
        this.workOfYear = workOfYear;
    }

    public SE(Integer workOfYear) {
        this.workOfYear = workOfYear;
    }

    public SE() {
    }

    @Override
    public String toString() {
        return "SE{" +
                "workOfYear=" + workOfYear +
                '}'+"Employee{" +
                "id=" +  super.getId()+
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge()+
                ", gender=" + super.getGender()+
                '}';
    }


}
