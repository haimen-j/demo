package com.zuson.demo.reflexDemp.controller;


import com.zuson.demo.reflexDemp.MySQLDBUtil;
import com.zuson.demo.reflexDemp.entity.Test;
import com.zuson.demo.reflexDemp.service.ReflexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class ReflexController {

   @Autowired
   ReflexService service;

  public static void main(String[] args) throws Exception {
      /*Connection connection = MySQLDBUtil.getConnection();
      String sql = "select id,name from text";
      PreparedStatement statement = connection.prepareStatement(sql);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()){
          Test test = new Test(resultSet.getInt("id"), resultSet.getString("name"));
          System.out.println(test);
      }
      MySQLDBUtil.closeConnection(connection);*/
      Class clazz = Class.forName("com.zuson.demo.reflexDemp.service.Impl.ReflexSerivceImpl");
      Method insert = clazz.getMethod("find");
      Object obj = clazz.newInstance();
      insert.invoke(obj);


  }

  public void insert(){
      service.insert();
  }
  public void update(){
      service.update();
  }
  public void delete(){
      service.delete();
  }
  public void find(){
      service.find();
  }

}
