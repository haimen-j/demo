package com.zuson.demo.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {

    public static void main(String[] args) {
        //创建mq连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                Constant.USER,
                Constant.PASSWORD,
                Constant.URL
        );
        //创建连接
        //创建session会话
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue user = session.createQueue("user");
            MessageProducer producer = session.createProducer(user);
            for (int i = 0; i < 100; i++) {
                TextMessage message = session.createTextMessage("hello word  "+i);
//                Thread.sleep(1000);
                producer.send(message);
            }
            session.commit();
            connection.close();
            System.out.println("system exit...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
