package com.zuson.demo.reflexDemp.service.Impl;

import com.zuson.demo.reflexDemp.MySQLDBUtil;
import com.zuson.demo.reflexDemp.entity.Test;
import com.zuson.demo.reflexDemp.service.ReflexService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ReflexSerivceImpl implements ReflexService {


    @Override
    public void insert() {
        Connection connection = MySQLDBUtil.getConnection();
        String sql = "insert into text(name) values(?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,"zhenyaxin");
            int i = statement.executeUpdate();
            System.out.println("受影响的条数："+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            MySQLDBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void update() {
        Connection connection = MySQLDBUtil.getConnection();
        String sql = "update text set name = ? where id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,"zyx");
            statement.setInt(2,2);
            int i = statement.executeUpdate();
            System.out.println("受影响的条数："+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            MySQLDBUtil.closeConnection(connection,statement);
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {
    Connection connection = MySQLDBUtil.getConnection();
      String sql = "select id,name from text";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Test test = new Test(resultSet.getInt("id"), resultSet.getString("name"));
                System.out.println(test);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            MySQLDBUtil.closeConnection(connection,statement,resultSet);
        }
    }
}
