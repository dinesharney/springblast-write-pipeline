package com.example.springblast.controller;

import com.example.springblast.entity.Payload;
import com.example.springblast.service.BufferedWriterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DataController {

    private final BufferedWriterService writerService;

    @PostMapping("/data")
    public ResponseEntity<String> write(@RequestBody Payload payload) {
        //log.info("Inside Controller");
        writerService.enqueue(payload);
        return ResponseEntity.ok("Enqueued");
    }
}

