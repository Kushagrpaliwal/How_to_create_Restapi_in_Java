package com.kushagrapaliwal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	@Autowired
	database db;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(db.getdata());
	}
}
