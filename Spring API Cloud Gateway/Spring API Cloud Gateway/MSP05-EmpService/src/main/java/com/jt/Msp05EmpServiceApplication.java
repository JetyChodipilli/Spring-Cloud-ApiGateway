package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Msp05EmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp05EmpServiceApplication.class, args);
	}

}
