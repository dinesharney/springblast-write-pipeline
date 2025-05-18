package com.example.springblast.controller;

import com.example.springblast.entity.Payload;
import com.example.springblast.repository.PayloadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DataController {

    @Autowired
    PayloadRepository repository;


    @PostMapping("/data")
    public String save(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        repository.save(payload);
        return "Saved " +payload.getId();
    }
}
