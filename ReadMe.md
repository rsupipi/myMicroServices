# Swagger

Swagger is the documentation, for restful services.

***Add dependencies.***
- x-swagger2
- springfox-swagger-ui

```xml
        <!-- swagger -->

		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```

***Configure Swagger***

create class and do the configurations
```java
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
```

***API docs:*** http://localhost:8080/v2/api-docs

***Swagger ui:***http://localhost:8080/swagger-ui.html

## Details in api-docs
22_swagger-api-dcs.PNG, 
23_swagger_api-docs.json

```json
swagger: <swagger version>
info: <information about documentation>
basePath: <base path for services>
host: <running host>
tags: < resource (controllers)>
paths: <path for services>
definiction: <what are the elements in >

```