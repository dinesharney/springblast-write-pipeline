package com.example.springblast.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClassicSpringDataJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassicSpringDataJdbcApplication.class, args);
	}

}
