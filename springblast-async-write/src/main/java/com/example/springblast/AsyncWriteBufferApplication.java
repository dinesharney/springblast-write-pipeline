package com.example.springblast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsyncWriteBufferApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncWriteBufferApplication.class, args);
	}
}
