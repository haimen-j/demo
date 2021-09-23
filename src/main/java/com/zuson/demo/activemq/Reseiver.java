package com.zuson.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Reseiver {

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                Constant.USER,
                Constant.PASSWORD,
                Constant.URL
        );
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true,Session.SESSION_TRANSACTED);
            Queue user = session.createQueue("user");
            MessageConsumer consumer = session.createConsumer(user);
            while (true){
                TextMessage receive = (TextMessage) consumer.receive();
                Thread.sleep(1000);
                receive.acknowledge();
                session.commit();
                System.out.println("接收到的消息："+receive.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
