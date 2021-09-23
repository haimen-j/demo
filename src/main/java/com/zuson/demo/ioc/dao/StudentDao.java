package com.zuson.demo.ioc.dao;

import com.zuson.demo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends BaseDao<Student> {
    @Override
    public void save() {
        System.out.println("保存学生。。。");
    }
}
