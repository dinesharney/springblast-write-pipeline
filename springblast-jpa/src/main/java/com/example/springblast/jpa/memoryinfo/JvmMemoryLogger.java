package com.example.springblast.jpa.memoryinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JvmMemoryLogger {

    //@PostConstruct
    @Scheduled(fixedRate = 20000)
    public void logJvmMemory() {
        long totalMemory = Runtime.getRuntime().totalMemory();     // Xms
        long maxMemory = Runtime.getRuntime().maxMemory();         // Xmx
        long freeMemory = Runtime.getRuntime().freeMemory();       // Free inside current heap
        long usedMemory = totalMemory - freeMemory;

        log.info("=== JVM Memory Info ===");
        log.info("Initial Heap (Xms): " + (totalMemory / (1024 * 1024)) + " MB");
        log.info("Max Heap (Xmx): " + (maxMemory / (1024 * 1024)) + " MB");
        log.info("Used Heap: " + (usedMemory / (1024 * 1024)) + " MB");
        log.info("Free Heap: " + (freeMemory / (1024 * 1024)) + " MB");
        log.info("========================");
    }
}
