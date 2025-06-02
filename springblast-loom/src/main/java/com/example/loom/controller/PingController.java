
package com.example.loom.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class PingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/ping")
    public String ping() {
        return "PONG " + counter.incrementAndGet();
    }
}
