package com.grocery.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Grocery Helper Application main class.
 * 
 * @author Bijoy Baral
 *
 */
@SpringBootApplication(scanBasePackages = {"com.grocery.helper.*"})
public class GroceryHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryHelperApplication.class, args);
	}

}
