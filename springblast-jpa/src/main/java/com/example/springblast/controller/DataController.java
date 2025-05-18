package com.example.springblast.controller;

import com.example.springblast.entity.Payload;
import com.example.springblast.repository.PayloadRepository;
import com.example.springblast.service.WriterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Writer;

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
