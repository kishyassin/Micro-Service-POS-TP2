# POS Microservices

A Spring Boot and Spring Cloud microservices architecture for a Point of Sale (POS) system.

## Services Architecture

| Service | Build Tool | Port | Description |
|---|---|---|---|
| **discovery-service** | Maven | `8761` | Eureka Service Discovery |
| **gateway-service** | Gradle | `9988` | Spring Cloud API Gateway |
| **customer-service** | Gradle | `8790` | Customer management service |
| **invantory-service** | Gradle | `8791` | Product inventory service |
| **billing-service** | Maven | `8787` | Billing and invoice service |

---

## Prerequisites

- **Java 17+**
- Maven & Gradle (wrappers included)

---

## How to Run

Start the services in the following order:

### 1. Discovery Service (Start First)
```bash
cd discovery-service
./mvnw spring-boot:run
```
Eureka Dashboard will be available at: [http://localhost:8761](http://localhost:8761)

### 2. Microservices
Run each in a separate terminal:

```bash
# Customer Service
cd customer-service
./gradlew bootRun

# Inventory Service
cd invantory-service
./gradlew bootRun

# Billing Service
cd billing-service
./mvnw spring-boot:run
```

### 3. API Gateway
```bash
cd gateway-service
./gradlew bootRun
```

---

## Main Endpoints

### Direct Service URLs
- **Eureka Dashboard**: `http://localhost:8761`
- **Customers**: `http://localhost:8790/customers`
- **Products**: `http://localhost:8791/products`
- **Bills**: `http://localhost:8787/bills`

### Routed via API Gateway (Port 9988)
- **Customers**: `http://localhost:9988/customers`
- **Products**: `http://localhost:9988/products`
