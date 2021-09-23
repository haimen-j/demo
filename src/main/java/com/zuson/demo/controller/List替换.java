package com.zuson.demo.controller;

import com.zuson.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class List替换 {

  public static void main(String[] args) {

      Student s1 = new Student("zhen1",1,1,1);
      Student s2 = new Student("zhen2",2,2,2);
      Student s3 = new Student("zhen3",3,3,3);
      Student s4 = new Student("zhen4",4,4,4);
      List<Student> list = new ArrayList<>();
      list.add(s1);
      list.add(s2);
      list.add(s3);
      list.add(s4);
      System.out.println("替换前：---------------------");
        for (Student student : list) {
            System.out.println(student);
        }
      System.out.println("替换后：---------------------");
      Student student = list.stream().filter(p -> p.getName().equals("zhen1")).findAny().orElse(null);
      int index = list.indexOf(student);
      student.setName("newZhen1");
      student.setPm10(-1);
      student.setPm25(-1);
      list.set(index,student);
      for (Student stu : list) {
          System.out.println(stu);
      }
  }
}
