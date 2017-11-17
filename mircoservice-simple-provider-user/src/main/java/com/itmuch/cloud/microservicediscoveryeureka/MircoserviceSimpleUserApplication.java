package com.itmuch.cloud.microservicediscoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MircoserviceSimpleUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoserviceSimpleUserApplication.class, args);
	}
}
