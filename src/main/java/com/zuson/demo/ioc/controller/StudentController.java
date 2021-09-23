package com.zuson.demo.ioc.controller;

import com.zuson.demo.ioc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

     public void save(){
         studentService.save();
     }

}
