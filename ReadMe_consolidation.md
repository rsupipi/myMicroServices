# Note:

- [Url for the tutorial](https://www.learningcrux.com/course/master-microservices-with-spring-boot-and-spring-cloud)

- Install JSON viewer chrome plugin for formatted JSON.

- [All notes in git hub](https://github.com/in28minutes/spring-microservices)

- [Standard Ports and  URLs:](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices)

# (1) Microservices
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

# (2) Creating Spring Boot application

## Create the project:

	1. got to  [https://start.spring.io/](https://start.spring.io/)
	2. select -> maven -> java -> select version( getting snapshots are not commended)
	3. select dependancies [Web, DevTool, Actuator, config client]
`04_start_Spring_Application.PNG`
`05_start_Spring_Application_dependancies.PNG`

## Run the project

* run it via the IDE
Run configuration -> + SpringBoot -> add `MyMicroServicesApplication` -> ok -> click run


# (3) Web Services

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

# (4) REST
## 1. Annotations

```java
@RequestMapping(method = RequestMethod.GET, path = "hello")

@GetMapping("hello")
@PostMapping("user")
@DeleteMapping("user/{id}")
@PutMapping("user/{id}")
``` 

## 2. REST project

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
URL: http://localhost:8080/hello

***output:***
```json
hi pipi
```

## 3. Returen bean

```java
    @GetMapping("hello-bean")
    public Message helloBean(){
        return new Message("hi pipi");
    }
```

* getters and setters should be define of the bean.

URL: http://localhost:8080/hello-bean

***output:***
```json
{
    "myMessage": "hi pipi"
}
```


## 4. Add `@PathVariable`

```java
    @GetMapping("hello/user/{name}")
    public Message helloPathVariable(@PathVariable String name){
        return new Message(String.format("Hello %s", name));
    }
```

* getters and setters should be define of the bean.

URL: http://localhost:8080/hello-bean

***output:***
```json
{
    "myMessage": "Hello RuchiraSupipi"
}
```

***output:***
URL: http://localhost:8080/hello

hello pipi

## 5. HATEOAS
**Hypermedia as the Engine of Application State**

*A client interacts with a REST API entirely through the responses provided dynamically by the server.*
*Put even more simply: You shouldn't need any documentation or out-of-band information to use a REST API.*

***pom.xml***
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

***UserController***
```java
    @GetMapping("/users3/{id}")
    public Resource<User> retrieveUser3(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        Resource resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

```
***output***
13_HETEOAS.PNG


## 6. Validation

***UserController.java***
```java
    @PostMapping("/users3")
    public ResponseEntity<Object> createUser3(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
```

***User.java***
```java
public class User {
    private int id;

    @Size(min = 2) // validate the size for 2 letters
    private String name;

    @Past // validate this should be a past date
    private Date birthDate;
}
```

***request:***

URL: `http://localhost:8080/users3`

requst body:
```json
{
    "id": 0,
    "name": "R",
    "birthDate": "1998-02-24T05:17:50.850+0000"
}
```

***output :***

12_validation.PNG

status: 400 Bad request

### custom validation

***CustomizedResponseEntityExceptionHandler.java***
```java
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//                ex.getBindingResult().toString());

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Faild",
                ex.getBindingResult().toString());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
```

******
```java
    @PostMapping("/users3")
    public ResponseEntity<Object> createUser3(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
```

```java
public class User {
    private int id;

    @Size(min = 2 , message = "Name should have at least 2 char") // validate the size for 2 letters
    private String name;

    @Past // validate this should be a past date
    private Date birthDate;
}
```


## 7. Exception Handling

### create custom class for handling 

***Exception***
```java
/** Returning the Status code */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
```

***Controller***
```java
    @GetMapping("/users2/{id}")
    public User retrieveUser2(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }
```

`11_content_notFound.PNG`

### Implementing Generic Exception Handling For All Resources

```java
@ControllerAdvice /* to be applicable across all controller */
@RestController /** this is a kind of controller */
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

// handle all exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

// handle notFound exception
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(UserNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
```
output:
11_genericExceptionHandler.PNG
11_genericExceptionHandler_02.PNG

# (5) Creating a hardcoded service

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

***3. output:***
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

# (6) Bean and Services

```java
@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    // get all ==================================================
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    // get by ID ==================================================
    @GetMapping("/users1/{id}")
    public User retrieveUser1(@PathVariable int id) {
        return userService.findOne(id);
    }

    @GetMapping("/users2/{id}")
    public User retrieveUser2(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // save  ==================================================
    @PostMapping("/users1")
    public User createUser1(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * returning status code and Location URI
     **/
    @PostMapping("/users2")
    public ResponseEntity<Object> createUser2(@RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // delete ==================================================
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);

        if (user == null){
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }
}
```

URL: GET -> http://localhost:8080/users/2

Response:
```json
{
    "id": 2,
    "name": "mala",
    "birthDate": "2020-02-24T05:17:50.850+0000"
}
```

URL: GET -> http://localhost:8080/users

Response:
```json
[
    {
        "id": 1,
        "name": "sama",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    },
    {
        "id": 2,
        "name": "mala",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    },
    {
        "id": 3,
        "name": "amara",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    }
]
```

URL: POST -> http://localhost:8080/users
Request:
```json
{
    "id": 0,
    "name": "kamala",
    "birthDate": "2000-02-24T05:17:50.850+0000"
}
```
09_PostCreateNewUser.PNG

Response:
```json
{
    "id": 4,
    "name": "kamala",
    "birthDate": "2000-02-24T05:17:50.850+0000"
}
```

* with status code:
10_PostCreateNewUser_statusCode.PNG

# (7) Internationalization

***create 2 property files***

*message.properties*
```properties
good.morning.message=good Morming
```
*message_lk.properties*
```properties
good.morning.message=Ayubowan
```

- we can create class for each language. and add each propreties according to the language.

***MyMicroServicesApplication.java***
```java
@Bean
public LocaleResolver localeResolver(){
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.US);
    return localeResolver;
}

@Bean
public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("message");
    return messageSource;
}
```

***HelloWordController.java***
```java
@RestController
@ResponseBody
public class HelloWordController {

    @Autowired
    private MessageSource messageSource;
    
    // Internalization =================================================
        @GetMapping("/hello-internalization")
        public String heollInternalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
          // return "good morning";
             return messageSource.getMessage("good.morning.message", null, locale);
        }
                
```

***output:***
*`Accept-Language` is the parameter. we pass here*

the output will be displayed accorng to the language
14_Internalization_lk.PNG

## Localecontext holder

Advantage of this is, we do not need send in request parameter.

***HelloWordController.java***
```java
/** According to this we have to add locale in every request. Since it is is painful to use, we can use
     * LocalContextHolder instead of this.
     * */
    @GetMapping("/hello-internalization2")
    public String heollInternalization() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
```

***MyMicroServicesApplication.java***
```java
	/** locale with Locale Resolver*/
	@Bean
	public LocaleResolver localeResolver(){
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver(); // remove
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver(); // add
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

//	We can remove this and move the configuration to application.properties.
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("message");
//		return messageSource;
//	}
```

***application.properties***
```properties
spring.messages.basename=message
```

***output***

15_Internalization_AccepetHeader_default.PNG
16_Internalization_AccepetHeader_lk.PNG

# (8) content Negotiation

- In Spring the default format is JSON.

15_Internalization_AccepetHeader_default.PNG

16_Internalization_AccepetHeader_lk.PNG

- **Jackscon** - does the binding of the object to json and json to object.
- If we need to get xml we need to add xml dependency.

```xml
    <!-- Link the XML conversion -->
    <dependency>
        <groupId>com.fasterxml.jackson.dataformat</groupId>
        <artifactId>jackson-dataformat-xml</artifactId>
        <!-- <version>1.18.12</version>-->
        <!-- We don't need to specify the version, the Spring dependency management handles that.-->
    </dependency>
```

***outputs:***

19_ContentNegotiation_xml_yes_get.PNG

20_ContentNegotiation_xml_yes_get_byID.PNG

21_ContentNegotiation_xml_yes_POST.PNG

# (9) Swagger

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

***SwaggerConfig.java***

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
























# (8) Get configuration from application properties

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

# (9) Spring Cloud config server
`03_Spring_config_server.png`

Here we establish the connection with the springCloudServer and the git repository.

* it store multiple configurations, in different services.
[currencyCalculationService, CurrencyExchangeService, LimitServce]

* it can store configuration in different environments
[LimitService-> dev, QA, stage, Production]