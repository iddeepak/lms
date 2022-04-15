package com.java.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementSystemApplication {
	public static boolean status = false;
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		status =true;
	}

}
