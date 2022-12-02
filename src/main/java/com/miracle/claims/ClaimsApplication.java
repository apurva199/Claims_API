package com.miracle.claims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableMongoRepositories
@EnableSwagger2
//@EnableDiscoveryClient
public class ClaimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimsApplication.class, args);
	}

}
