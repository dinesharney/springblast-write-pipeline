package com.example.springblast.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClassicSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassicSpringDataJpaApplication.class, args);
	}

}
