import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * 点对点模式测试
 */
public class Test1 {

    /**
     * 发送消息
     */
    @Test
    public void send() throws JMSException {
        //  1、创建一个连接工厂对象(指定服务的ip、端口)
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //  2、从工厂中获取一个连接对象并开启
        Connection connection = factory.createConnection();
        connection.start();

        //  3、创建Session对象：
        //  参数1-是否开启事务、
        //  参数2-签收模式：(在事务false前提下生效)
        //  AUTO_ACKNOWLEDGE        自动签收：消费者receive消息的时候自动签收
        //  CLIENT_ACKNOWLEDGE      手动签收：消费者receive消息后必须手动的调用acknowledge()方法进行签收
        //  DUPS_OK_ACKNOWLEDGE     无所谓：签不签收无所谓了，只要消费者能够容忍重复的消息接受，当然这样会降低Session的开销
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //  4、使用Session对象创建目标类型：(Queue是点对点、Topic是发布-订阅)
        Queue queue = session.createQueue("testQueue");

        //  5、使用Session对象创建Producer对象   ★
        MessageProducer producer = session.createProducer(queue);

        //  6、创建Message对象(直接new/session创建)
        //  TextMessage message = new ActiveMQTextMessage();
        //  message.setText("消息具体内容");
        TextMessage textMessage = session.createTextMessage("Queue消息具体内容");

        //  7、发送Message
        producer.send(textMessage);

        //  8、关闭资源
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
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("testQueue");
        //  使用Session对象创建Consumer对象 ★
        MessageConsumer consumer = session.createConsumer(queue);
        //  接受消息
        //  1、同步：Message receive = consumer.receive();
        //  2、异步
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
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }

}
