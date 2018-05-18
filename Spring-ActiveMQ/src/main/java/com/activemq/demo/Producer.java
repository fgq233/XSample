package com.activemq.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producer {


    public static void main(String[] args) {
        ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:applicationContext-activemq.xml");

        //  1、从Spring容器中获取JmsTemplate
        JmsTemplate jmsTemplate = (JmsTemplate) ac.getBean("jmsTemplate");
        //  2、从Spring容器中获Destination
        Destination destination  = (Destination) ac.getBean("queueDestination");
        //  3、发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("消息内容：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        });

    }


}
