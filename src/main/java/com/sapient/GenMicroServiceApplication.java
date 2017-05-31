package com.sapient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.jms.annotation.EnableJms;


import com.sapient.jms.MessageProducer;

//
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class GenMicroServiceApplication implements CommandLineRunner  {

	@Autowired
	private MessageProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(GenMicroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Service started");
		for (int i = 0; i < 5; i++) {
			producer.sendMessages();
		}
			System.out.println("5 message Sent");
		
	

	}	

}
