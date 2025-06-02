
package com.example.loom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
public class LoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoomApplication.class, args);
    }

    @Bean
    public TomcatProtocolHandlerCustomizer<?> virtualThreadExecutorCustomizer() {
        return protocolHandler -> protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    }
}
