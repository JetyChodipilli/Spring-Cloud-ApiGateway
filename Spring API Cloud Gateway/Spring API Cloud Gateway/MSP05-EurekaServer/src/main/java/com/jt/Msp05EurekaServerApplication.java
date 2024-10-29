package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Msp05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp05EurekaServerApplication.class, args);
	}

}
