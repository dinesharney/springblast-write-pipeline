package com.example.springblast.service;

import com.example.springblast.entity.Payload;
import com.example.springblast.repository.PayloadRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@Service
@RequiredArgsConstructor
public class BufferedWriterService {

    private final PayloadRepository repository;
    private final Queue<Payload> buffer = new ConcurrentLinkedQueue<>();

    private static final int BATCH_SIZE = 100;

    public void enqueue(Payload payload) {
        buffer.add(payload);
    }

    @Scheduled(fixedDelay = 100)
    public void flushBuffer() {
        List<Payload> batch = new ArrayList<>();
        while (batch.size() < BATCH_SIZE && !buffer.isEmpty()) {
            batch.add(buffer.poll());
        }
        if (!batch.isEmpty()) {
            repository.saveAll(batch);
            log.info("Flushed {} records to PostgreSQL", batch.size());
        }
    }
}
