package com.example.springblast.r2dbc.controller;

import com.example.springblast.r2dbc.entity.Payload;
import com.example.springblast.r2dbc.repository.PayloadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DataController {

    private final PayloadRepository repository;

    public DataController(PayloadRepository repository) {
        this.repository = repository;
    }

    @PostMapping("data")
    public Mono<String> save(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        return repository.save(payload).thenReturn("Saved");
    }
}

