package com.example.springblast.async.controller;

import com.example.springblast.async.entity.Payload;
import com.example.springblast.async.service.BufferedWriterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/async")
@RequiredArgsConstructor
public class DataController {

    @Autowired
    BufferedWriterService writerService;

    @PostMapping("/data")
    public ResponseEntity<String> write(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        writerService.enqueue(payload);
        return ResponseEntity.ok("Enqueued");
    }
}

