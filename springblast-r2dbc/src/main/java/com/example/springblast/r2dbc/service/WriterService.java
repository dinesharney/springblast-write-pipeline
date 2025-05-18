package com.example.springblast.r2dbc.service;

import com.example.springblast.r2dbc.entity.Payload;
import com.example.springblast.r2dbc.repository.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WriterService {

    @Autowired
    PayloadRepository repository;

    public Mono<Payload> write(Payload payload) {
        return repository.save(payload);
    }

}
