package com.free.study.learn.more;

import java.net.URISyntaxException;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.Message;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQTTDemo {

    private static final Logger log = LoggerFactory.getLogger(MQTTDemo.class);

    private static MQTT mqtt;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException {
        mqtt = new MQTT();
        mqtt.setHost("localhost", 61613);
        mqtt.setUserName("admin");
        mqtt.setPassword("password");
        mqtt.setKeepAlive((short) 20);
    }

    @Test
    public void send() throws Exception {
        BlockingConnection connection = null;
        try {
            connection = mqtt.blockingConnection();
            connection.connect();
            connection.publish("foo", "Hello, Jack!".getBytes(), QoS.AT_LEAST_ONCE, false);
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
    }

    @Test
    public void subscribe() throws Exception {
        BlockingConnection connection = null;
        try {
            connection = mqtt.blockingConnection();
            connection.connect();
            Topic[] topics = {new Topic("foo", QoS.AT_LEAST_ONCE)};
            byte[] qoses = connection.subscribe(topics);
            log.info("qose:{}", qoses);
            while (true) {
                Message message = connection.receive();
                log.debug(message.getTopic());
                byte[] payload = message.getPayload();
                log.info("payload:{}", new String(payload));
                message.ack();
            }
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
    }
}
