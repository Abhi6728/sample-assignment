package com.abhi.sample_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class SampleAssignmentApplication {
	public static void main(String[] args) {

		SpringApplication.run(SampleAssignmentApplication.class, args);
	}

}
