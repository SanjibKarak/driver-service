package com.cts.driverms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Driverms1Application {

	public static void main(String[] args) {
		SpringApplication.run(Driverms1Application.class, args);
	}

}
