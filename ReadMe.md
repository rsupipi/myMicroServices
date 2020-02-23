# Spring Cloud config Server

## Setting up spring cloud config server

1. go to https://start.spring.io/
2. create project call `spring-cloud-config-server`. 
`07_SpringConfigServer.PNG`
`07_SpringConfigServer_dependancy.PNG`
3. dependancy -> Dev tool, config Server

* For managing purpose I have added this server to root in this project.

## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
|  |  |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

***application.properties***