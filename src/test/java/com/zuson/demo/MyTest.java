package com.zuson.demo;


import com.zuson.demo.ioc.controller.StudentController;
import com.zuson.demo.ioc.controller.TeacherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void iocTest(){
        StudentController studentController = context.getBean("studentController", StudentController.class);
        studentController.save();
        TeacherController teacherController = context.getBean("teacherController", TeacherController.class);
        teacherController.save();
    }

}
