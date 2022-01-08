package com.nttdata.bootcamp.microservicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Microservicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio1Application.class, args);
	}

}
