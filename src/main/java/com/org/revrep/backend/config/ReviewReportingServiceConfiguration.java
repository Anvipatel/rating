package com.org.revrep.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Anvi P
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.org.revrep")
@EnableMongoRepositories(basePackageClasses = com.org.revrep.backend.repository.ReviewRepo.class)
@EnableSwagger2
public class ReviewReportingServiceConfiguration {

	
	
	
	//public class SwaggerConfig extends WebMvcConfigurationSupport {
	    @Bean
	    public Docket reviewApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()                 .apis(RequestHandlerSelectors.basePackage("com.org.revrep"))
	                .paths(PathSelectors.regex("/review.*"))
	                .build();
	             
	    }
	  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("swagger-ui.html")
	                .addResourceLocations("classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**")
	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
	
}
