package com.zuson.demo.ioc.dao;

import com.zuson.demo.ioc.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher> {
    @Override
    public void save() {
        System.out.println("保存老师。。。");
    }
}
