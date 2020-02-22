# Web Services

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

## SAOP vs REST

	* Restriction vs Architectural style

# Microservices
	1.  REST
	2. Cloud enables
	3. small deploy-able units.

## chalenges
	1. Bounded context -> identify the boundry
	2. configuration management
	3. Visibility [how do i know all are up and runing]
	4. Pack of cards [fault tolerance]

## Dynamic ScaleUp
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

## Spring Cloud config server
`03_Spring_config_server.png`

# Creating Spring Boot application

	1. got to  [https://start.spring.io/](https://start.spring.io/)
	2. select -> maven -> java -> select version( getting snapshots are not commended)
	3. select dependancies [Web, DevTool, Actuator, config client]
`04_start_Spring_Application.PNG`
`05_start_Spring_Application_dependancies.PNG`


