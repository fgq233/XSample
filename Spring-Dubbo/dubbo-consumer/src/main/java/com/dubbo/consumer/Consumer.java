package com.dubbo.consumer;

import com.dubbo.api.SampleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-dubbo-consumer.xml");
        ac.start();

        System.out.println("调用者启动成功");

        //  开始调用服务
        SampleService service = ac.getBean(SampleService.class);
        System.out.println(service.sayHello("World !!!"));
        System.out.println(service.getCurrentTime());

    }
}
