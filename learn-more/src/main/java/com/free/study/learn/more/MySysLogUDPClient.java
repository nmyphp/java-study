package com.free.study.learn.more;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.graylog2.syslog4j.Syslog;
import org.graylog2.syslog4j.SyslogConfigIF;
import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.SyslogIF;
import org.junit.Test;

/**
 * Created by Administrator on 2018/12/12 0012.
 */
public class MySysLogUDPClient {

    private static final int PORT = 514;

    @Test
    public void sendUDP() {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.UDP);
        SyslogConfigIF config = syslog.getConfig();
        config.setHost(getHostAddress());
        config.setPort(PORT);
        syslog.error("这是一条UDP协议发送的日志");
    }

    @Test
    public void sendUDPStructured() {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.UDP);
        SyslogConfigIF config = syslog.getConfig();
        config.setHost(getHostAddress());
        config.setPort(PORT);
        config.setUseStructuredData(true);
        syslog.error("这是一条UDP协议（附带STRUCTURED-DATA信息）发送的日志");
    }

    @Test
    public void sendTCP() throws InterruptedException {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.TCP);
        SyslogConfigIF config = syslog.getConfig();
        config.setHost(getHostAddress());
        config.setPort(PORT);
        syslog.error("这是一条TCP协议发送的日志");
        Thread.sleep(1000L);
    }

    @Test
    public void sendTCPStructured() throws InterruptedException {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.TCP);
        SyslogConfigIF config = syslog.getConfig();
        config.setHost(getHostAddress());
        config.setPort(PORT);
        config.setUseStructuredData(true);
        syslog.error("这是一条TCP协议（附带STRUCTURED-DATA信息）发送的日志");
        Thread.sleep(1000L);
    }

    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "localhost";
        }
    }
}
