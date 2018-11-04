package com.free.dubbo.demo.provider;

import com.free.dubbo.demo.provider.dto.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟持久层
 */
@Slf4j
public class UserRespo {

    public String add(User user) {
        log.info("Add user->username:{},password:{}", user.getUsername(), user.getPassword());
        return "success";
    }

    public User find(String username) {
        log.info("Find user by username:{}", username);
        User user = new User();
        user.setUsername(username);
        user.setPassword("12234");
        return user;
    }
}
