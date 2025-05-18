package com.example.consumer.listener;

import com.example.consumer.model.Payload;
import com.example.consumer.repository.DataRepository;
import com.example.shared.WriteEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class WriteEventListener {

    private final DataRepository repository;

    public WriteEventListener(DataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "write-events", groupId = "jdbc-write-group")
    public void listen(@org.springframework.messaging.handler.annotation.Payload WriteEvent event) {
        Payload entity = new Payload();
        entity.setData(event.getData());
        entity.setCreatedAt(Instant.ofEpochMilli(event.getTimestamp()));
        repository.save(entity);
    }
}
