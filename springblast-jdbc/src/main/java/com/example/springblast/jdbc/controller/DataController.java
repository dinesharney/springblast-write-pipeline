package com.example.springblast.jdbc.controller;

import com.example.springblast.jdbc.entity.Payload;
import com.example.springblast.jdbc.repository.PayloadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DataController {

    @Autowired
    PayloadRepository repository;

    @PostMapping("/data")
    public String save(@RequestBody Payload payload) {
        log.info("Inside Controller");
        repository.save(payload);
        return "Saved";
    }
}

