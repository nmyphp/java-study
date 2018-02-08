package com.free.study.proxy;

/**
 * JDK动态代理demo
 * @author: chenlongjs
 * @date: 2018/2/8
 */
public class Main {

    public static void main(String[] args) {
        SimpleInterface realObject = new SimpleImpl();
        SimpleProxy proxy = new SimpleProxy();
        SimpleInterface proxyService = (SimpleInterface)proxy.bind(realObject);
        proxyService.say();
    }
}
