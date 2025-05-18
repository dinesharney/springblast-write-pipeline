package com.example.springblast.r2dbc.memoryinfo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JvmMemoryLogger {

    //@PostConstruct
    @Scheduled(fixedRate = 20000)
    public void logJvmMemory() {
        long totalMemory = Runtime.getRuntime().totalMemory();     // Xms
        long maxMemory = Runtime.getRuntime().maxMemory();         // Xmx
        long freeMemory = Runtime.getRuntime().freeMemory();       // Free inside current heap
        long usedMemory = totalMemory - freeMemory;

        System.out.println("=== JVM Memory Info ===");
        System.out.println("Initial Heap (Xms): " + (totalMemory / (1024 * 1024)) + " MB");
        System.out.println("Max Heap (Xmx): " + (maxMemory / (1024 * 1024)) + " MB");
        System.out.println("Used Heap: " + (usedMemory / (1024 * 1024)) + " MB");
        System.out.println("Free Heap: " + (freeMemory / (1024 * 1024)) + " MB");
        System.out.println("========================");
    }
}
