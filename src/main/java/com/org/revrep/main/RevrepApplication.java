package com.org.revrep.main;

import org.springframework.boot.SpringApplication;

import com.org.revrep.backend.config.ReviewReportingServiceConfiguration;

/**
 * @author Anvi P
 *
 */
public class RevrepApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReviewReportingServiceConfiguration.class, args);
	}

}
