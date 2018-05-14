package com.free.dubbo.demo.simulator;

import com.free.dubbo.demo.provider.ServiceImpl;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器端，相当于dubbo的Exporter
 */
public class Exporter {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static ServiceImpl service = new ServiceImpl();
    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        export();
    }

    /**
     * 模拟Dubbo的export方法，暴露服务，同时开启对客户端的监听
     * @throws Exception
     */
    public static void export() throws Exception{
        while (true) {

System.out.println("开启监听.......");

            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String data;

            try {
                while (null != (data = reader.readLine())) {

String msg = String.format("远端%s请求，内容：%s", accept.getInetAddress(), data);
System.out.println(msg);
                    // 收到一个客户端请求，并分发给线程池去处理，此处类似于Dubbo的Dispacher
                    final String temp = data;
                    executor.execute(() -> {
                        try {
                            String[] cellInfo = temp.split("#");
                            // 调用本地方法
                            String resultData = Invoker.invoke(cellInfo);
                            // 回告远端
                            Callback.callback(resultData);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reader.close();
                inputStream.close();
                accept.close();
            }
        }


    }

    public static class Invoker {

        public static String invoke(String[] cellInfo) throws Exception {
            Method method = ServiceImpl.class.getDeclaredMethod(cellInfo[1]);
            // 模拟结果序列化（文本）
            String result = method.invoke(service).toString();

String cellInfoMsg = String.format("远端调用方法：%s.%s，结果：%s", cellInfo[0], cellInfo[1], result);
System.out.println(cellInfoMsg);

            return result;
        }
    }

    public static class Callback {
        private static Socket callback;
        private static BufferedWriter writer;

        static {
            try {
                callback = new Socket("localhost", 6789);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void callback(String data) throws Exception{
            try {
                writer = new BufferedWriter(new OutputStreamWriter(callback.getOutputStream()));
                writer.write(data);
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
