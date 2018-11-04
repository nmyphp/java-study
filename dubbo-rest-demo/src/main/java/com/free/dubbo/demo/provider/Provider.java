package com.free.dubbo.demo.provider;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 服务提供者启动
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:dubbo-demo-provider.xml");
        context.start();
        // 阻塞
        System.in.read();
    }
}
