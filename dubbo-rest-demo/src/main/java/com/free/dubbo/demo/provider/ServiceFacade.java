package com.free.dubbo.demo.provider;

import com.free.dubbo.demo.provider.dto.User;

/**
 * 接口定义
 */
public interface ServiceFacade {
    String hello();

    String form(String username, String password);

    String form(User user);

    User query(String username);
}
