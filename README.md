# 🌐 Spring Cloud API Gateway for Microservices

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green.svg)
![Spring Cloud](https://img.shields.io/badge/SpringCloud-Gateway%20%26%20Eureka-orange.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📖 Overview

This project implements an **API Gateway** using Spring Cloud Gateway and Eureka Server for a microservices-based e-commerce application. The API Gateway serves as a single entry and exit point for all microservices, handling routing, authentication, and authorization. It simplifies client interactions by providing unified URLs and abstracts the complexity of managing multiple microservice endpoints.

Microservices included:
- 🧑‍💼 Employee REST API
- 🧾 Customer API
- 🛰️ Eureka Server
- 🚪 API Gateway

---

## 🏗️ Architecture

- **API Gateway**: Routes client requests to appropriate microservices using Spring Cloud Gateway  
- **Eureka Server**: Service registry for dynamic discovery  
- **Employee API**: Manages employee operations  
- **Customer API**: Manages customer profiles and orders  
- **Client Interaction**: Clients (e.g., Postman) send requests to the API Gateway, which uses Eureka to locate services

---

## 🧰 Technologies Used

- Java 17  
- Spring Boot 3.x  
- Spring Cloud Gateway  
- Spring Cloud Netflix Eureka  
- Maven  
- Postman  
- Dependencies:
  - `spring-cloud-starter-gateway`  
  - `spring-cloud-starter-netflix-eureka-client`  
  - `spring-boot-starter-actuator` *(optional)*  
  - `spring-cloud-starter-netflix-eureka-server`

---

## 📁 Project Structure

```text
spring-cloud-apigateway/
├── eureka-server/              # Eureka Server
│   └── src/main/java/com/ccp/EurekaServerApplication.java
├── api-gateway/                # API Gateway
│   └── src/main/java/com/ccp/ApiGatewayApplication.java
├── employee-api/               # Employee REST API
│   └── src/main/java/com/ccp/EmployeeApiApplication.java
├── customer-api/               # Customer API
│   └── src/main/java/com/ccp/CustomerApiApplication.java
├── assets/                     # Images (logo, diagrams)
└── README.md                   # Documentation
```

---

## 🛠️ Prerequisites

- Java 17+  
- Maven 3.6+  
- Postman  
- *(Optional)* Docker  
- *(Optional)* MySQL/PostgreSQL for Employee and Customer APIs

---

## ⚙️ Setup Instructions

### 📥 Clone the Repository

```bash
git clone <repository-url>
cd spring-cloud-apigateway
```

### 🔧 Configure Dependencies

Ensure each service’s `pom.xml` includes required dependencies:

**API Gateway:**

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
  <optional>true</optional>
</dependency>
```

**Eureka Server:**

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

### ⚙️ Configure Application Properties

**Eureka Server (`application.yml`):**

```yaml
server:
  port: 8761
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

**API Gateway (`application.yml`):**

```yaml
server:
  port: 8080
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

**Employee/Customer APIs:**  
Configure database and Eureka settings as needed.

---

## 🏗️ Build All Services

```bash
cd eureka-server && mvn clean install
cd ../api-gateway && mvn clean install
cd ../employee-api && mvn clean install
cd ../customer-api && mvn clean install
```

---

## ▶️ Run the Services

```bash
cd eureka-server
mvn spring-boot:run

cd ../api-gateway
mvn spring-boot:run

cd ../employee-api
mvn spring-boot:run

cd ../customer-api
mvn spring-boot:run
```

---

## 🔍 Verify Eureka Server

Visit [http://localhost:8761](http://localhost:8761) to confirm all services are registered.

---

## 📡 Usage

### 🔧 Test APIs with Postman

- **Gateway URL**: `http://localhost:8080`

#### Example Requests

- **Get Employees**  
  `GET http://localhost:8080/employee-api/employees`

- **Create Customer**  
  `POST http://localhost:8080/customer-api/customers`

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

> Import the Postman collection (if provided) for pre-configured requests.

---

## 🔄 Service Communication

Routing configuration in `api-gateway/application.yml`:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: employee-api
          uri: lb://EMPLOYEE-API
          predicates:
            - Path=/employee-api/**
        - id: customer-api
          uri: lb://CUSTOMER-API
          predicates:
            - Path=/customer-api/**
```

---

## 📊 Monitoring

- Eureka dashboard: [http://localhost:8761](http://localhost:8761)  
- Actuator health check: `http://localhost:8080/actuator/health`

---

## 📌 Sample API Endpoints

### 🧑‍💼 Employee REST API

- `GET /employee-api/employees` — List employees  
- `POST /employee-api/employees` — Create employee

```json
{
  "name": "Jane Smith",
  "role": "Developer"
}
```

### 🧾 Customer API

- `GET /customer-api/customers` — List customers  
- `POST /customer-api/customers` — Create customer

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

---

## 🧭 Architecture Diagram

> *(Add your diagram image to `assets/` and embed it here)*

---

## 📝 Notes

- Start Eureka Server before other services  
- Use Spring Cloud Gateway instead of Zuul  
- Each microservice can scale independently  
- Customize routing in `api-gateway/application.yml`

---

## 🛠️ Troubleshooting

| Issue                  | Solution                                                                 |
|------------------------|--------------------------------------------------------------------------|
| Service Not Registered | Check Eureka dashboard and `defaultZone` config                         |
| Routing Issues         | Ensure service IDs match Eureka registry                                |
| Port Conflicts         | Update `server.port` in `application.properties`                        |
| README Wrapping        | Use LF line endings and proper Markdown formatting                      |

```bash
sed -i 's/\r$//' README.md
git add README.md
git commit -m "Fix line endings"
git push origin main
```

---

## 🚀 Future Enhancements

- Add authentication/authorization with Spring Security + JWT  
- Implement circuit breakers with Resilience4j  
- Add payment service  
- Deploy with Docker & Kubernetes  
- Integrate Prometheus & Grafana for monitoring

---

## 🤝 Contributing

Contributions are welcome! Submit pull requests or open issues for bugs, improvements, or new features.

---

## 📜 License

This project is licensed under the **MIT License**.
