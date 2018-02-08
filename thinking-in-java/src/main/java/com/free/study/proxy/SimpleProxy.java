package com.free.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * @author: chenlongjs
 * @date: 2018/2/8
 */
public class SimpleProxy implements InvocationHandler{

    private Object target;

    /**
     * 绑定委托类，并返回一个代理对象
     * @param target 委托类
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("即将调用委托类的方法：" + method);
        Object result = method.invoke(this.target, args);
        System.out.println("已经调用委托类的" + method + "方法");
        return result;
    }
}
