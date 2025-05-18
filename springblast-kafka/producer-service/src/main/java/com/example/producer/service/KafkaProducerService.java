package com.example.producer.service;

import com.example.shared.WriteEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, WriteEvent> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topic;

    public void send(WriteEvent event) {
        kafkaTemplate.send(topic, event.getId(), event);
    }
}