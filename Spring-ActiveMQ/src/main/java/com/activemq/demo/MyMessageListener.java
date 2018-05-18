package com.activemq.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("消费者消费了消息：" + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
