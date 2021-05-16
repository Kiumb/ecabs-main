package com.ecabs.producer;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcabsProducerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ECabProducerApplication.class, args);
		SpringApplication app = new SpringApplication(EcabsProducerApplication.class);
		 app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8081"));
		 app.run(args);
	}

}
