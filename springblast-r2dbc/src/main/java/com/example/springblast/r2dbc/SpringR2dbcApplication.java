package com.example.springblast.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringR2dbcApplication.class, args);
	}

}
