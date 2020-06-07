package com.techfynder.forex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForexApplication {
	private static final Logger logger = LoggerFactory.getLogger(ForexApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(ForexApplication.class, args);
		logger.info("ForexApplication started..............");
	}

}
