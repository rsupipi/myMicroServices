package com.pipi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //Configuration
@EnableSwagger2 // enable swagger
public class SwaggerConfig {

    // bean -docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2);
    }

    //Swagger 2

    //All the paths

    // All the api

}
