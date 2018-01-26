package com.free.dubbo.demo.provider;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/26
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:dubbo-demo-provider.xml");
        context.start();
        // 阻塞
        System.in.read();
    }
}
