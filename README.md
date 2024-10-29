# Spring-Cloud-ApiGateway
API Gateway:
	Api Gateway Acts a Single Entry and Exit gateway  for the application for all the microservices of the project.It can perform Authentication and Authorization.Different Micro Services of the project run on different port numbers having different urls and its practically immposible to remeber all those port numbers and urls separtely,so we need a single entry and exit point having unique urls for all the microservices of the project thats why we use API Gateway.
		Netflix Zuul is best in earlier but Industry Standards is Spring Cloud Gateway.Since Eureka Server Cant communicate with Microservice and cant make http calls to interact with any Microservice.Its Just there to register details of One Microservice can use one or another client code to find the details about Microservice and to interact with that Microservice.
				By Using common url of the api gateway we interact only with that MS whose details are placed in API Gateway by linking with common urls.
		Projects to Develope:
			a)Eureka Server Projects
			b)Employee Rest API
			c)Customer API
			d)Spring Cloud API
		Dependencies to take in the Project:
			1)Gateway stater
			2)Spring Boot Actutaors(optional)
			3)Discovery Client
			4)Eureka Server
