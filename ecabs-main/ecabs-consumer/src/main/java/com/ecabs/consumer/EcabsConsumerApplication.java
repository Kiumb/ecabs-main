package com.ecabs.consumer;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcabsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EcabsConsumerApplication.class);
		 app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8085"));
		 app.run(args);
	}

}
