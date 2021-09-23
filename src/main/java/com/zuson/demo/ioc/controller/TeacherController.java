package com.zuson.demo.ioc.controller;

import com.zuson.demo.ioc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    public void save(){
        teacherService.save();
    }
}
