package com.free.study.learn.more;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.graylog2.syslog4j.server.SyslogServerEventIF;
import org.graylog2.syslog4j.server.SyslogServerIF;
import org.graylog2.syslog4j.server.SyslogServerSessionEventHandlerIF;
import org.graylog2.syslog4j.util.SyslogUtility;

public class SyslogServerEventHandler implements SyslogServerSessionEventHandlerIF {

    @Override
    public Object sessionOpened(SyslogServerIF syslogServerIF, SocketAddress socketAddress) {
        return null;
    }

    private static final ObjectMapper objMapper = new ObjectMapper();

    @Override
    public void event(Object session, SyslogServerIF syslogServer, SocketAddress socketAddress,
        SyslogServerEventIF event) {
        Map printVO = new HashMap<String, String>();
        String date = event.getDate().toString();
        printVO.put("date", date);
        //将解析日志的生成端,<<3是要该数左移动三位计算
        String facility = SyslogUtility.getFacilityString(event.getFacility() << 3);
        printVO.put("facility", facility);
        //讲解析日志的级别，级别越大越低
        String level = SyslogUtility.getLevelString(event.getLevel());
        printVO.put("level", level);
        //获取当前的源设备IP
        String sourceIP = getIPAddress(socketAddress.toString());
        printVO.put("sourceIP", sourceIP);
        String msg = event.getMessage();
        printVO.put("msg", msg);
        printVO.put("raw", new String(event.getRaw()));
        try {
            System.out.println(objMapper.writeValueAsString(printVO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private String getIPAddress(String bString) {
        String regEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(bString);
        String result = "";
        while (m.find()) {
            result = m.group();
            break;
        }
        return result;
    }

    @Override
    public void exception(Object o, SyslogServerIF syslogServerIF, SocketAddress socketAddress, Exception e) {

    }

    @Override
    public void sessionClosed(Object o, SyslogServerIF syslogServerIF, SocketAddress socketAddress, boolean b) {

    }

    @Override
    public void initialize(SyslogServerIF syslogServerIF) {

    }

    @Override
    public void destroy(SyslogServerIF syslogServerIF) {

    }
}
