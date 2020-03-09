# Monitoring APIs with SpringBoot actuator.

```xml

		<!-- actuator monitor services-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<!-- Actuator is providing lot of monitoring facilities-->

		<!--Hal browser-->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
		</dependency>
		<!-- Hypertext Application Language - is a specific format that gives a consitent and easy way to hyperlink
		 between resources in your API. 'starter-actuators' are in the HAL format.
		 * what Hal browsers does is it look at it's API, identify links and show them on the screen.
		  -->
```

## Actuator URL
it has changed according to the Spring version.

- http://localhost:8080/actuator : (after 2.0 release latest)
or
- http://localhost:8080/application
or
http://localhost:8080

* this will open hal browser if you have the hal dependency.
http://localhost:8080 or http://localhost:8080/browser/index.html
* But it gave me an error. Still I don't know. :(

output:
25_actuator_links.json
26_actuator_links_health.json

## actuator with full feature

`application.properties`
```properties
# === add more features to actuator ==========
management.endpoints.web.exposure.include=*
```

***output***
27_actuator_links_fulFeature.json