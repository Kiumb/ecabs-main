package com.ecabs.root;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcabsBeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EcabsBeApplication.class);
		 app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8083"));
		 app.run(args);
	}

}
