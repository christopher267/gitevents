package com.charles.gitevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GiteventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiteventsApplication.class, args);
	}
	
}
