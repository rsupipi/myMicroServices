

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

## Bean and Services

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

# Exception Handling

## create custom class for handling 

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

## Implementing Generic Exception Handling For All Resources

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

## REST project

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

## Returen bean

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


## Add path variables

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

# Note:
Install JSON viewer chrome plugin for formatted JSON.

[All notes in git hub](https://github.com/in28minutes/spring-microservices)

[Standard Ports and  URLs:](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices)
