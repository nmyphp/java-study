package com.free.dubbo.demo.provider;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/26
 */
@Path("demo")
public class ServiceImpl implements ServiceFacade {

    @Override
    @Path("hello")
    @GET
    public String hello() {
        return "Hello World! ";
    }
}
