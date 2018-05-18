import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 *  一对多模式测试
 */
public class Test2 {

    /**
     * 发送消息
     */
    @Test
    public void send() throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("testTopic"); //  ★
        MessageProducer producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("Topic消息具体内容");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }

    /**
     * 接受消息
     */
    @Test
    public void get() throws JMSException, IOException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        //  connection.setClientID("consumer_1");   设置客户端ID，用于持久化订阅
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("testTopic"); //  ★
        MessageConsumer consumer = session.createConsumer(topic);
        //  session.createDurableSubscriber(topic,"consumer_1");  不论持久化订阅者在不在线，那么他的消息会暂存在MQ，以后都会发给他！
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage msg = (TextMessage) message;
                try {
                    System.out.println(msg.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("Consumer1：已启动");
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }

}
