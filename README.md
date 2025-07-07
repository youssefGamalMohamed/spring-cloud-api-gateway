# Spring Cloud API Gateway

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)
[![Java](https://img.shields.io/badge/Java-17-007396?logo=java&logoColor=white)](https://adoptopenjdk.net/)
[![Redis](https://img.shields.io/badge/Redis-DC382D?logo=redis&logoColor=white)](https://redis.io/)
[![Zipkin](https://img.shields.io/badge/Zipkin-000000?logo=apache&logoColor=white)](https://zipkin.io/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)](https://www.docker.com/)
[![Reactive](https://img.shields.io/badge/Reactive-5A29E4?logo=react&logoColor=white)](https://projectreactor.io/)
[![Keycloak](https://img.shields.io/badge/Keycloak-1E2526?logo=keycloak&logoColor=white)](https://www.keycloak.org/)
[![Hey](https://img.shields.io/badge/Hey-4B275F?logo=go&logoColor=white)](https://github.com/rakyll/hey)

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
- **Docker Compose**: Spin up dependencies (Redis, Zipkin, Keycloak) with a single command.
- **Reactive & Non-blocking**: Built on Spring WebFlux for high concurrency.
- **Authentication & Authorization**: Secured with Keycloak for OAuth2 and JWT-based authentication.

---

## 🚀 Getting Started

### Prerequisites

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) (for running dependencies)
- [Hey](https://github.com/rakyll/hey) (for stress testing)

### Clone the Repository

```bash
git clone https://github.com/your-username/spring-cloud-api-gateway.git
cd spring-cloud-api-gateway
```

### Start Dependencies

```bash
docker compose up -d
```

### Configure Keycloak

After starting the Docker Compose services, configure Keycloak:

1. Access the Keycloak Admin Console at [http://localhost:8080](http://localhost:8080).
2. Log in with the credentials:
   - Username: `admin`
   - Password: `admin`
3. Import the realm configuration:
   - Navigate to the Keycloak Admin Console.
   - Click on the realm dropdown (top-left) and select **"Add realm"**.
   - Choose the `realm-settings.json` file located in the `imports/keykloak/` folder of the project.
   - Click **Create** to import the `json-placeholder-realm` configuration.

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
| ![Keycloak](https://img.shields.io/badge/-Keycloak-1E2526?logo=keycloak&logoColor=white) | Authentication & authorization |
| ![Hey](https://img.shields.io/badge/-Hey-4B275F?logo=go&logoColor=white) | Stress testing tool |

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
imports/
  keykloak/
    realm-settings.json
```

---

## ⚙️ Configuration

- **Routes** and **filters** are defined in [`application.yaml`](src/main/resources/application.yaml).
- **Rate limiting** and **custom filters** are configured in the `configs` and `filters` packages.
- **Tracing** is enabled and configured for Zipkin.
- **Authentication** is configured with Keycloak in `application.yaml` and `realm-settings.json`.

---

## 📊 Observability

- **Zipkin UI**: [http://localhost:9411](http://localhost:9411)
- **Actuator Endpoints**: [http://localhost:8080/actuator](http://localhost:8080/actuator)

---

## 🧪 Testing

Run all unit tests:

```bash
./mvnw test
```

### Stress Testing

To perform stress testing on the API Gateway, we use the `hey` tool to simulate load. Below is an example command to test the `GET /posts/{id}` endpoint:

```bash
hey -n 100 -c 100 -m GET \
-H "Authorization: Bearer $TOKEN_VALUE" \
http://localhost:9090/posts/1
```

Replace `$TOKEN_VALUE` with a valid JWT token obtained from Keycloak.

**Example Stress Test Result**:

```plaintext
Summary:
  Total:        4.1552 secs
  Slowest:      4.1550 secs
  Fastest:      0.4334 secs
  Average:      3.2293 secs
  Requests/sec: 24.0665

Response time histogram:
  0.433 [1]     |■
  0.806 [5]     |■■■■
  1.178 [6]     |■■■■■
  1.550 [3]     |■■■
  1.922 [0]     |
  2.294 [0]     |
  2.666 [0]     |
  3.038 [0]     |
  3.411 [14]    |■■■■■■■■■■■■
  3.783 [45]    |■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  4.155 [26]    |■■■■■■■■■■■■■■■■■■■■■■■

Latency distribution:
  10% in 1.0938 secs
  25% in 3.3998 secs
  50% in 3.5556 secs
  75% in 3.8002 secs
  90% in 3.9024 secs
  95% in 3.9245 secs
  99% in 4.1550 secs

Details (average, fastest, slowest):
  DNS+dialup:   0.0090 secs, 0.4334 secs, 4.1550 secs
  DNS-lookup:   0.0022 secs, 0.0000 secs, 0.0108 secs
  req write:    0.0013 secs, 0.0000 secs, 0.0058 secs
  resp wait:    3.2180 secs, 0.4223 secs, 4.1318 secs
  resp read:    0.0008 secs, 0.0000 secs, 0.0228 secs

Status code distribution:
  [200] 5 responses
  [429] 95 responses
```

The high number of `[429]` responses indicates that the rate limiter (configured in `application.yaml`) is effectively throttling requests.

---

## 🤝 Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements.

---

## 👤 Author

[Youssef Gamal](https://github.com/your-username)

---

## 📬 Contact

For questions or support, please open an issue or contact me via [GitHub](https://github.com/your-username).

---