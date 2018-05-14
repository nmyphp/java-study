package com.free.dubbo.demo.provider;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/26
 */
public interface ServiceFacade {
    String hello();
    String form(String username, String password);
}
