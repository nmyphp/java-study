package com.free.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class ConsumerDemo implements AcknowledgingMessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord, Acknowledgment acknowledgment) {
        //TODO 这里具体实现个人业务逻辑
        // 最后 调用acknowledgment的ack方法，提交offset
        acknowledgment.acknowledge();
    }
}