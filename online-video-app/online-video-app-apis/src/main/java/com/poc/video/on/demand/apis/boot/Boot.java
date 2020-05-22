package com.poc.video.on.demand.apis.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.poc.video.on.demand.apis")
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
