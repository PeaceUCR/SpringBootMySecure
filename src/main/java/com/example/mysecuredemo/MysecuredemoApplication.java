package com.example.mysecuredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class MysecuredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysecuredemoApplication.class, args);
	}
}
