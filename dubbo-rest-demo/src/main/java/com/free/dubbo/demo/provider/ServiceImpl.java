package com.free.dubbo.demo.provider;


import com.free.dubbo.demo.provider.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Dubbo,Rest两种协议接口实现
 */
@Path("demo")
public class ServiceImpl implements ServiceFacade {

    private UserRespo userRespo = new UserRespo();

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
    public String form(@QueryParam("username") String username, @QueryParam("password") String password) {
        return username + "#" + password;
    }

    @Override
    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String form(User user) {
        return userRespo.add(user);
    }

    @Override
    @Path("query")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User query(@QueryParam("username") String username) {
        return userRespo.find(username);
    }
}
