# Get configuration from application properties

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