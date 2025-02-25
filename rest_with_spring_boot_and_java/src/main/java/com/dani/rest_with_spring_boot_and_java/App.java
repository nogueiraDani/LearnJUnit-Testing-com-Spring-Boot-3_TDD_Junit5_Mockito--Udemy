package com.dani.rest_with_spring_boot_and_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		
		SpringApplication.run(App.class, args);
	}

}
