package com.zuson.demo.fanxing;

/**
 * 项目经理类
 */
public class PM<e> extends Employee<e>{

    private Integer popularity;

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public PM(Integer id, String name, Integer age, e gender, Integer popularity) {
        super(id, name, age, gender);
        this.popularity = popularity;
    }

    public PM(Integer popularity) {
        this.popularity = popularity;
    }
}
