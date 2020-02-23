# Creating a hardcoded service

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