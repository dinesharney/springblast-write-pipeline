package com.example.springblast.jpa.controller;

import com.example.springblast.jpa.entity.Payload;
import com.example.springblast.jpa.service.WriterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/jpa")
public class DataController {

    @Autowired
    WriterService writerService;


    @PostMapping("/data")
    public String save(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        Long id = writerService.write(payload).getId();
        return "Saved " +id;
    }
}
