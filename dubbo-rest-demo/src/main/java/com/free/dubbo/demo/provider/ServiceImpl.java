package com.free.dubbo.demo.provider;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


    @Override
    @Path("form")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String form(@QueryParam("username") String username, @QueryParam("password") String password) {
        return username + "#" + password;
    }
}
