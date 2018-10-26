package com.free;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 包装Http请求工具
 */
public class HttpUtil {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * Http请求
     *
     * @param uri
     * @return 字符串格式的结果
     * @throws IOException
     */
    public static String get(String uri) throws IOException {
        return get(uri, null);
    }

    /**
     * GET请求，携带header信息
     * @param uri
     * @param headers
     * @return
     * @throws IOException
     */
    public static String get(String uri, Map<String, Object> headers) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        // add headers
        if (null != headers && !headers.isEmpty()) {
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue().toString());
            }
        }
        CloseableHttpResponse response = httpClient.execute(httpGet);
        return getResponseBody(response);
    }

    /**
     * Post请求
     *
     * @param uri
     * @param parameters 请求参数
     * @return
     * @throws IOException
     */
    public static String post(String uri, Map<String, Object> parameters) throws IOException {
        if (!parameters.isEmpty()) {
            HttpPost httpPost = new HttpPost(uri);
            List<NameValuePair> nvps = new ArrayList<>(10);
            for (Map.Entry<String, Object> item : parameters.entrySet()) {
                nvps.add(new BasicNameValuePair(item.getKey(), item.getValue().toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return getResponseBody(response);
        } else {
            return get(uri);
        }
    }

    /**
     * 获取返回内容
     *
     * @param response
     * @return
     * @throws IOException
     */
    private static String getResponseBody(CloseableHttpResponse response) throws IOException {
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != statusCode) {
                throw new RuntimeException("Request failure, statusCode is " + statusCode);
            } else {
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
                return responseBody;
            }
        } finally {
            response.close();
        }
    }
}
