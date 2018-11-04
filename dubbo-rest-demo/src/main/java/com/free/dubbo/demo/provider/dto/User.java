package com.free.dubbo.demo.provider.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User implements Serializable {
    private String username;
    private String password;
}
