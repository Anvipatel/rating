package com.org.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.rating.backend.config.ProductRatingServiceConfiguration;


@SpringBootApplication
public class ProductRatingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductRatingServiceConfiguration.class, args);
	}
}
