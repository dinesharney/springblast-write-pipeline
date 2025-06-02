
package com.example.loom.controller;

import com.example.loom.entity.Payload;
import com.example.loom.repository.PayloadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/loom")
public class DataController {

    private static final Logger log = LoggerFactory.getLogger(DataController.class);

    private final PayloadRepository repository;

    public DataController(PayloadRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/data")
    public String saveData(@RequestBody String data) {
        //log.info("Handling request in thread: " + Thread.currentThread());
        Payload payload = new Payload();
        payload.setData(data);
        payload.setCreatedAt(Instant.now());
        repository.save(payload);
        return "Saved";
    }
}
