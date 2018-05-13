package com.cxf.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-cxf.xml");
        SampleService proxy = (SampleService) ac.getBean("myClient");
        String result = proxy.getCurrentTime("随风飘扬的笑");
        System.out.println(result);
    }

}
