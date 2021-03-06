package com.org.rating;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Anvi P
 *
 */
@Configuration
@ComponentScan("com.org.rating.web.rest")
@EnableSwagger2
public class SwaggerConfig {                               
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.org.rating"))
          .paths(PathSelectors.any())                          
          .build().useDefaultResponseMessages(false);                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Product-Rating-Service-V1")
                .description("Created on : " + new Date().toString()).version("1.0.0")
                .build();
    }
}
