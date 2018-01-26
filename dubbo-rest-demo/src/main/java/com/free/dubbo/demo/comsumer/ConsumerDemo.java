package com.free.dubbo.demo.comsumer;

import com.free.dubbo.demo.provider.ServiceFacade;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2018/1/26
 */

public class ConsumerDemo {
    public static void main(String[] args) throws Exception{
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:dubbo-demo-consumer.xml");
        context.start();

        // Test dubbo protocal
        ServiceFacade serviceDemo = context.getBean(ServiceFacade.class);
        System.out.println("Dubbo result: " + serviceDemo.hello());

        // Test rest protocal
        HttpClient client = HttpClientBuilder.create()
                .build();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .build();
        HttpGet httpGet = new HttpGet("http://localhost:8080/demo/hello");
        httpGet.setConfig(config);

        HttpResponse httpResponse = client.execute(httpGet);
        int statusCode = httpResponse.getStatusLine()
                .getStatusCode();

        if (200 != statusCode) {
            System.out.println("WARN: Response code is" + statusCode);
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), Charset.forName("UTF-8"));

        Assert.notNull(response, "Return null when invoke rest interface. ");
        System.out.println("Rest result: " + response);
    }

}
