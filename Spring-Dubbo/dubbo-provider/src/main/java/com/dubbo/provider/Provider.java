package com.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {

   public static void main(String[] args) throws IOException {
       ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-dubbo-provider.xml");
       ac.start();
       System.out.println("服务启动成功......");
       System.in.read();// 按任意键退出
   }

}
