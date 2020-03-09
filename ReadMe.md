# Swagger

Swagger is the documentation, for restful services.

This documentation sould be more discriptive and more detailed one to understand
to the consumer.

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

## Customized api-doc

```java
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Ranga Karanam", "http://www.in28minutes.com", "in28minutes@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Awesome API Title", "Awesome API Description", "1.0",
			"urn:tos", DEFAULT_CONTACT, 
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json",
					"application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
```

here we re changing the `apiInfo`, `produces` and `consumes`

### changing definitions in api-doc

```java
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about user")   // swagger api-doc
public class User {
    private int id;

@ApiModelProperty(notes = "Name should have 2 characters")  // swagger api-doc
private String name;

@ApiModelProperty(notes = "Birth date should be in past date")  // swagger api-doc
private Date birthDate;
```

* for more annotations go to: 24_swagger-annotations.PNG