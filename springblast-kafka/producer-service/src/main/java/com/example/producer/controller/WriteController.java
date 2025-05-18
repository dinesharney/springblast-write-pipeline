package com.example.producer.controller;

import com.example.shared.WriteEvent;
import com.example.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class WriteController {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/data")
    public ResponseEntity<String> send(@RequestBody WriteEvent event) {
        kafkaProducerService.send(event);
        return ResponseEntity.ok("Sent to Kafka");
    }
}