package com.zuson.demo.reflexDemp;

import com.zuson.demo.reflexDemp.entity.Test;
import com.zuson.demo.reflexDemp.entity.User1;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BaseDaoUtil {
    //统一的查询工具类
    public List getRows(String sql, Object [] params, Class<?> clazz){
        List list = new ArrayList();
        Connection connection = MySQLDBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            if (null!=params && params.length!=0){
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i+1,params[i]);
                }
            }
            resultSet = statement.executeQuery();
            //获取结果集中的元素的对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //判断查询到的每一行记录中包含多少列
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                //创建放置具体结果属性的对象
                Object obj = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //从结果集中获取单一列的值 用于判断
                    Object objectValue = resultSet.getObject(i + 1);
//                    System.out.println("获取到的单一列的值："+objectValue);
                    //获取列的名称
                    String columnName = metaData.getColumnName(i + 1).toLowerCase();
//                    System.out.println("获取到的列名："+columnName);
                    //获取类中的属性
                    Field declaredField = clazz.getDeclaredField(columnName);
//                    System.out.println("类中字段的属性："+declaredField.getName());
//                    System.out.println("类中字段的属性："+declaredField.getType().getName());
//                    System.out.println("类中字段的属性："+declaredField.getModifiers());
                    //获取对象的set方法
                    Method method = clazz.getMethod(getSetName(columnName), declaredField.getType());
                    //判断值的类型
                    if (objectValue instanceof Number){
                        Number number = (Number) objectValue;
                        String pname = declaredField.getType().getName();
                        if ("byte".equals(pname) || "java.lang.Byte".equals(pname)){
                            method.invoke(obj,number.byteValue());
                        }else if ("short".equals(pname) || "java.lang.Short".equals(pname)){
                            method.invoke(obj,number.shortValue());
                        }else if ("int".equals(pname) || "java.lang.Integer".equals(pname)){
                            method.invoke(obj,number.intValue());
                        }else if ("long".equals(pname) || "java.lang.Long".equals(pname)){
                            method.invoke(obj,number.longValue());
                        }else if ("double".equals(pname) || "java.lang.Double".equals(pname)){
                            method.invoke(obj,number.doubleValue());
                        }else if ("float".equals(pname) || "java.lang.Float".equals(pname)){
                            method.invoke(obj,number.floatValue());
                        }
                    }else {
                        method.invoke(obj,objectValue);
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLDBUtil.closeConnection(connection,statement,resultSet);
        }

        return list;
    }

    public  String getSetName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }
    public  String getGetName(String name){
        return "get"+name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }


    public void saveInfo(String sql,Object obj,Class clazz){
        Connection connection = MySQLDBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            //获取类中元素的值
            Class<?> objClass = obj.getClass();
            Object o1 = objClass.newInstance();
            //获取对象中所有的属性
            Field[] fields = objClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                //设置属性为可以访问
                fields[i].setAccessible(true);
                //获取对象中的属性值
                Object o = fields[i].get(obj);
                statement.setObject(i+1,o);
            }
            int i = statement.executeUpdate();
            System.out.println("受影响条数："+i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            MySQLDBUtil.closeConnection(connection,statement);
        }

    }

   public static void main(String[] args) {
      BaseDaoUtil base = new BaseDaoUtil();
       /*List<User1> rows = base.getRows("select * from user1", new Object[]{}, User1.class);
       for (User1 row : rows) {
        System.out.println(row);
       }*/
       Test test = new Test();
       test.setName("zhangsanaa");
       base.saveInfo("insert into text (id,name) values (?,?) ",test,Test.class);
       User1 user1 = new User1();
       user1.setName("zyx");
       user1.setSex(1);
       user1.setTime(new Date());
       base.saveInfo("insert into user1  values (?,?,?,?) ",user1,User1.class);

   }
}
