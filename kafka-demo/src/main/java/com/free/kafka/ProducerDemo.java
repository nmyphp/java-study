package com.free.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by chenlongjs on 2017/9/25.
 */
@Slf4j
public class ProducerDemo {

    private static Properties properties = new Properties();
    private static Producer<String, String> producer;

    static {
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);
    }

    public static void main(String[] args) throws Exception {
        String msg = "{\"orderId\":1411566028,\"eventType\":400001001,\"eventDate\":\"2016-01-11 21:17:53\",\"eventArg\":null}";
        try {
            producer.send(new ProducerRecord<>("orderSend", msg));
            log.info("发送Kafka消息成功!");
        } catch (Exception e) {
            log.error("发送Kafka消息发生异常！", e);
        } finally {
            producer.close();
        }
    }

}
