## SpringBlast Write Pipeline (JPA vs JDBC vs R2DBC)

This project demonstrates how to design high-performance **Spring Boot microservices** capable of handling **5000+ writes per second (WPS)** using three different persistence strategies:

- JPA (Hibernate)
- Spring Data JDBC
- Spring WebFlux + R2DBC

First version uses an H2 in-memory database and exposes a REST endpoint for high-throughput inserts.

---

## Repository Structure

| Module              | Tech Stack                    | Highlights                                 |
|---------------------|-------------------------------|--------------------------------------------|
| `springblast-jpa`   | Spring Boot + JPA + Hibernate | Full-featured ORM, Hibernate batching      |
| `springblast-jdbc`  | Spring Boot + JDBC            | Lightweight persistence, manual schema     |
| `springblast-r2dbc` | WebFlux + R2DBC + H2          | Fully non-blocking, reactive, async insert |

---

## Features

- Spring Boot 3.2+
- In-memory H2 DB (for easy testing)
- OpenAPI (Swagger UI)
- Optimized for 5K+ WPS throughput
- Ready for benchmarking with `ab`, `wrk`, or `k6`

---

## Getting Started


### 1. Clone the Repo


git clone https://github.com/your-org/springblast-write-pipeline.git
cd springblast-write-pipeline

### 2. Run a Submodule
Choose one of the modules: cd springblast-jpa or springblast-jdbc or springblast-r2dbc
./mvn clean install
./mvnw spring-boot:run

### 3. Sample Payload
{
  "data": "Hello SpringBlast!"
}

### 4. Load Testing with Apache Bench (ab)
ab -n 5000 -c 50 -p payload.json -T application/json http://localhost:8080/api/data

### 5. H2 Console Access
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb



