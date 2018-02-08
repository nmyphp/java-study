package com.free.study.proxy;

/**
 * 委托类
 * @author: chenlongjs
 * @date: 2018/2/8
 */
public class SimpleImpl implements SimpleInterface {

    @Override
    public void say() {
        System.out.println("Hello, Kitty! ##########");
    }
}
