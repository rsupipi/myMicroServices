

# 5. Spring Cloud config server
`03_Spring_config_server.png`

Here we establish the connection with the springCloudServer and the git repository.

* it store multiple configurations, in different services.
[currencyCalculationService, CurrencyExchangeService, LimitServce]

* it can store configuration in different environments
[LimitService-> dev, QA, stage, Production]


# 4. Get configuration from application properties

***1. application.properties***

add application name
```properties
spring.application.name=pipi-service

limit-service.minimum=99
limit-service.maximum=9999
```
***2. Configuration.java***

get configuration from `application.properties`
```java
@Component /** @ConfigurationProperties is sufficient to register bean as a component**/
@ConfigurationProperties("limit-service")
@Getter @Setter  /** should be generate getters and setters**/
public class Configuration {
    private int maximum;
    private int minimum;

}

```
***3. LimitsConfigurationContorller.java***

create a controller class
```java
@RestController
public class LimitsConfigurationContorller {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfigurations(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

}
```

***3. Run the project***

* run it via the IDE
Run configuration -> + SpringBoot -> add `MyMicroServicesApplication` -> ok -> click run

* using maven
`mvn clean install`
`mvn spring-boot:run`

***URL***
http://localhost:8080/limits

***output***
```json
{
    "maximum": 9999,
    "minimum": 99
}
```

# 3. Creating a hardcoded service

***1. application.properties***

add application name
```properties
spring.application.name=limits-service
```

***2. LimitsConfigurationContorller.java***

create a controller class
```java
@RestController
public class LimitsConfigurationContorller {

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfigurations(){
        return new LimitConfiguration(100, 1);
    }

}
```

***3. Run the project***

* run it via the IDE
Run configuration -> + SpringBoot -> add `MyMicroServicesApplication` -> ok -> click run

* using maven
`mvn clean install`
`mvn spring-boot:run`

***URL***
http://localhost:8080/limits

***output***
```json
{
    "maximum": 100,
    "minimum": 1
}
```

# 2. Creating Spring Boot application

	1. got to  [https://start.spring.io/](https://start.spring.io/)
	2. select -> maven -> java -> select version( getting snapshots are not commended)
	3. select dependancies [Web, DevTool, Actuator, config client]
`04_start_Spring_Application.PNG`
`05_start_Spring_Application_dependancies.PNG`

# 1. Web Services

## SAOP vs REST

	* Restriction vs Architectural style

## 1. SOAP:

	1. Use XML for request and response
	2. Transport over the internet(HTTP) or MQ(Message Ques)
	3.WSDL(Web service definition)

		1. Endpoint
		2. All operation
		3. request structure
		4. response structure
`01_SOAP_request_structure.PNG`
`02_SOAP_request.PNG`

## 2. REST
	1. HTTP Methods
		1. GET
		2. POST
		3. PUT
		4.  DELETE
	2. Status code
		1. 200
	3. A resource has an URL(uniform resource identifier)
	4. data exchange format -> XML, HTML, JSON
	5. transport  -> only HTTP [rest is build on top of HTTP]
	6. Service definition -> no standard. (WADL, swagger..)
	7. REST is a style of software architecture for distributed hypermedia system

Representation state transfer: `08_RESTful_webService.PNG`

## Annotations

```java
@RequestMapping(method = RequestMethod.GET, path = "hello")

@GetMapping("hello")
@PostMapping("user")
@DeleteMapping("user/{id}")
@PutMapping("user/{id}")
``` 

### REST project

***1. HelloWordController.java controller***
```java
@RestController
public class HelloWordController {

    //@RequestMapping(method = RequestMethod.GET, path = "hello")
    @GetMapping("hello")    /** This is short and sweet**/
    public String helloWorld(){
        return "hello pipi";
    }
}
```

***output:***
URL: http://localhost:8080/hello

hello pipi

# Microservices
	1.  REST
	2. Cloud enables
	3. small deploy-able units.

## chalenges
	1. Bounded context -> identify the boundry
	2. configuration management
	3. Visibility [how do i know all are up and runing]
	4. Pack of cards [fault tolerance]

### Dynamic ScaleUp
	* Euraka - Naming server
	* Rebbon - client side load balancing
	* Feign - Easier rest client

## Visibility and monitoring
	* Zipkin  - distributed service
	* Netflix - API gateway

## Fault Tolerance
	* Hystrix

## Advantages
	* new technology and process adaption.
	* Dynamic scaling.
	* Faster Release cycle

## [Standard Ports and  URLs:](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices)

# Note:
Install JSON viewer chrome plugin for formatted JSON.