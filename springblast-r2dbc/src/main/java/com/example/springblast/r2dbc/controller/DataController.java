package com.example.springblast.r2dbc.controller;

import com.example.springblast.r2dbc.entity.Payload;
import com.example.springblast.r2dbc.repository.PayloadRepository;
import com.example.springblast.r2dbc.service.WriterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/r2dbc")
public class DataController {

    @Autowired
    WriterService writerService;

    @PostMapping("data")
    public Mono<String> save(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        return writerService.write(payload).thenReturn("Saved");
    }
}

