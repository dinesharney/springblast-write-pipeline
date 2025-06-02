package com.example.springblast.r2dbc.memoryinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

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
        int activeThreads = Thread.activeCount();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int count = threadMXBean.getThreadCount();

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();
        System.out.println("JVM thread count: " + count);

        log.info("=== JVM Memory Info ===");
        log.info("Initial Heap (Xms): " + (totalMemory / (1024 * 1024)) + " MB");
        log.info("Max Heap (Xmx): " + (maxMemory / (1024 * 1024)) + " MB");
        log.info("Used Heap: " + (usedMemory / (1024 * 1024)) + " MB");
        log.info("Free Heap: " + (freeMemory / (1024 * 1024)) + " MB");
        log.info("Available processors: " + Runtime.getRuntime().availableProcessors());
        log.info("Approx Active threads: " + activeThreads);
        log.info("JVM thread count: " + count);
        log.info("========================");
        log.info("=== Heap Memory Usage: === ");
        log.info("  Init:      {} MB", heap.getInit() / (1024 * 1024));
        log.info("  Used:      {} MB", heap.getUsed() / (1024 * 1024));
        log.info("  Committed: {} MB", heap.getCommitted() / (1024 * 1024));
        log.info("  Max:       {} MB", heap.getMax() / (1024 * 1024));
        log.info("========================");
    }
}
