package com.free.dubbo.demo.simulator;

import com.free.dubbo.demo.provider.ServiceFacade;
import com.free.dubbo.demo.provider.ServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟Dubbo的Protocal
 */
public class Protocal {

    public static void main(String[] args) throws Exception{
//        ServiceFacade serviceFacade = new ServiceImpl();
//        serviceFacade.hello();
        new Proxy().hello();

    }

    /**
     * 模拟Dubbo生成的代理
     */
    public static class Proxy {
        private static ServiceFacade serviceFacade = new ServiceImpl();

        public String hello() throws Exception{
            return Invoker.remoteInvoke("ServiceImpl#hello");
        }
    }

    /**
     * 模拟客户端的Invoker
     */
    public static class Invoker {
        private static Socket socket;
        private static BufferedWriter writer;

        static {
            try {
                socket = new Socket("localhost", 1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 模拟消费端的远程调用
        public static String remoteInvoke(String cellInfo) throws Exception {
            try {
                System.out.println("开始调用远端方法" + cellInfo);
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(cellInfo);
                writer.flush();
                writer.close();
                return Callback.callback();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {

            }
        }
    }

    /**
     * 模拟回调接口
     */
    public static class Callback {
        private static ServerSocket callback;
        private static BufferedReader reader;

        static {
            try {
                callback = new ServerSocket(6789);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String callback() throws Exception {
            Socket accept = callback.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String result = reader.readLine();
System.out.println("获得远端方法结果：" + result);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                reader.close();
                inputStream.close();
                accept.close();
            }
        }
    }
}
