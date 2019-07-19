package com.free.study.proxy;

/**
 * JDK动态代理demo
 *
 * @author: chenlongjs
 * @date: 2018/2/8
 */
public class Main {

    public static void main(String[] args) {
        // 保存生成的代理类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IHello realObject = new MyHello();
        DynamicProxy proxy = new DynamicProxy();
        IHello hello = (IHello) proxy.bind(realObject);
        hello.say();
    }
}
