package com.example.springblast.controller;

import com.example.springblast.entity.Payload;
import com.example.springblast.repository.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    PayloadRepository repository;


    @PostMapping
    public String save(@RequestBody Payload payload) {
        repository.save(payload);
        return "Saved " +payload.getId();
    }
}
