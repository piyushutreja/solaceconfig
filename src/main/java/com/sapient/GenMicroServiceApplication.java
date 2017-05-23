package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class GenMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenMicroServiceApplication.class, args);
	}
}
