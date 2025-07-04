# Spring Cloud API Gateway

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)
[![Java](https://img.shields.io/badge/Java-17-007396?logo=java&logoColor=white)](https://adoptopenjdk.net/)
[![Redis](https://img.shields.io/badge/Redis-DC382D?logo=redis&logoColor=white)](https://redis.io/)
[![Zipkin](https://img.shields.io/badge/Zipkin-000000?logo=apache&logoColor=white)](https://zipkin.io/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)](https://www.docker.com/)
[![Reactive](https://img.shields.io/badge/Reactive-5A29E4?logo=react&logoColor=white)](https://projectreactor.io/)

---

## Overview

A robust **API Gateway** built with [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway), designed to demonstrate and implement common API Gateway patterns such as **security**, **rate-limiting**, **routing**, **resilience**, and **observability**.

This project is ready for extension and integration with microservices architectures.

---

## ✨ Features

- **Dynamic Routing**: Easily route requests to backend services.
- **Rate Limiting**: Protect your APIs using Redis-backed rate limiting.
- **Resilience Patterns**: Circuit breaker, retry, and fallback using Resilience4j.
- **Distributed Tracing**: Integrated with Zipkin and Micrometer Tracing.
- **Metrics & Monitoring**: Expose actuator endpoints for health and metrics.
- **Custom Filters**: Add custom logic (e.g., request ID injection) via global filters.
- **Docker Compose**: Spin up dependencies (Redis, Zipkin) with a single command.
- **Reactive & Non-blocking**: Built on Spring WebFlux for high concurrency.

---

## 🚀 Getting Started

### Prerequisites

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) (for running dependencies)

### Clone the Repository

```bash
git clone https://github.com/your-username/spring-cloud-api-gateway.git
cd spring-cloud-api-gateway
```

### Start Dependencies

```bash
docker compose up -d
```

### Run the Application

```bash
./mvnw spring-boot:run
```

---

## 🛠️ Tools & Technologies

| Tool/Tech           | Description                        |
|---------------------|------------------------------------|
| ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?logo=springboot&logoColor=white) | Application framework |
| ![Spring Cloud Gateway](https://img.shields.io/badge/-Spring%20Cloud%20Gateway-6DB33F?logo=spring&logoColor=white) | API Gateway |
| ![Java](https://img.shields.io/badge/-Java%2017-007396?logo=java&logoColor=white) | Programming language |
| ![Redis](https://img.shields.io/badge/-Redis-DC382D?logo=redis&logoColor=white) | Rate limiting backend |
| ![Zipkin](https://img.shields.io/badge/-Zipkin-000000?logo=apache&logoColor=white) | Distributed tracing |
| ![Docker](https://img.shields.io/badge/-Docker-2496ED?logo=docker&logoColor=white) | Containerization |
| ![Micrometer](https://img.shields.io/badge/-Micrometer-5A29E4?logo=react&logoColor=white) | Metrics & tracing |
| ![Resilience4j](https://img.shields.io/badge/-Resilience4j-4F8EF7?logo=java&logoColor=white) | Resilience patterns |

---

## 📦 Project Structure

```
src/
  main/
    java/
      com.youssef.gamal.microservices.spring_cloud_api_gateway/
        SpringCloudApiGatewayApplication.java
        configs/
        filters/
  resources/
    application.yaml
test/
  java/
    ...
compose.yml
README.md
pom.xml
```

---

## ⚙️ Configuration

- **Routes** and **filters** are defined in [`application.yaml`](src/main/resources/application.yaml).
- **Rate limiting** and **custom filters** are configured in the `configs` and `filters` packages.
- **Tracing** is enabled and configured for Zipkin.

---

## 📊 Observability

- **Zipkin UI**: [http://localhost:9411](http://localhost:9411)
- **Actuator Endpoints**: [http://localhost:8080/actuator](http://localhost:8080/actuator)

---

## 🧪 Testing

Run all tests:

```bash
./mvnw test
```

---

## 🤝 Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👤 Author

[Youssef Gamal](https://github.com/your-username)

---

## 📬 Contact

For questions or support, please open an issue or contact me via [GitHub](https://github.com/your-username).

---
