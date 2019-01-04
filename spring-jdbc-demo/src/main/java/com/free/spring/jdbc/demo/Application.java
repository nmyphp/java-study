package com.free.spring.jdbc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @description: Spring Jdbc demo
 * @author: chenlongjs
 * @date: 2017/12/19
 */

@ComponentScan({"com.free.spring.condition", "com.free.spring.jdbc.demo"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("Spring-jdbc-demo is started! ");
    }
}
