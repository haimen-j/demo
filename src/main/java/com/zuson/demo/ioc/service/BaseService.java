package com.zuson.demo.ioc.service;

import com.zuson.demo.ioc.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;

    public void save(){
        baseDao.save();
    }
}
