package com.example.contentmakerapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
public class ContentMakerApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContentMakerApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
