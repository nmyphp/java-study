package com.free;

import org.junit.Test;

/**
 * Spring Cloud 消费者
 */
public class App {
    @Test
    public void testAdd() throws Exception {
        String result = HttpUtil.get("http://localhost:2222/add?a=100&b=200");
        System.out.println("result:" + result);
    }
}
