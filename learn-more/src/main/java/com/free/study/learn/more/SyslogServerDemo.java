package com.free.study.learn.more;

import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.server.SyslogServerConfigIF;
import org.graylog2.syslog4j.server.SyslogServerIF;

/**
 * Created by Administrator on 2018/12/12 0012.
 */
public class SyslogServerDemo {

    private static final int PORT = 514;

    private static void startTCPServer() {
        SyslogServerIF server = org.graylog2.syslog4j.server.SyslogServer.getInstance(SyslogConstants.TCP);
        SyslogServerConfigIF config = server.getConfig();
        config.setHost(SyslogClientDemo.getHostAddress());
        config.setPort(PORT);
        config.addEventHandler(new MySyslogEventHandler());
        org.graylog2.syslog4j.server.SyslogServer.getThreadedInstance(SyslogConstants.TCP);
        System.out.println("TCP SyslogServer started");
        while (true) {

        }
    }

    private static void startUDPServer() {
        SyslogServerIF server = org.graylog2.syslog4j.server.SyslogServer.getInstance(SyslogConstants.UDP);
        SyslogServerConfigIF config = server.getConfig();
        config.setHost(SyslogClientDemo.getHostAddress());
        config.setPort(PORT);
        config.addEventHandler(new MySyslogEventHandler());
        org.graylog2.syslog4j.server.SyslogServer.getThreadedInstance(SyslogConstants.UDP);
        System.out.println("UDP SyslogServer started");

    }

    public static void main(String[] args) {
        startUDPServer();
        startTCPServer();
        while (true) {

        }
    }
}
