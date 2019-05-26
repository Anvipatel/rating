package com.org.rating.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.org.rating")
@EnableMongoRepositories(basePackages = "com.org.rating.backend.repository")
public class ProductRatingServiceConfiguration {

}
