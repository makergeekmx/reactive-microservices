# Reactive Microservices Demo

This workspace contains a multi-service demo built with Spring Boot WebFlux, Kafka, and a React frontend.

Services:
- `product-service` — products and categories CRUD.
- `inventory-service` — inventory management and in/out notifications.
- `supplier-service` — suppliers and supplier order management.
- `user-service` — user management.
- `notification-service` — Kafka-driven notification delivery.
- `frontend` — React UI with Material UI and Axios.

## Run

1. Start Kafka and PostgreSQL with Docker Compose:
   ```bash
   docker compose up -d
   ```
2. Build and run each service from its directory:
   ```bash
   mvn clean spring-boot:run
   ```
3. Start the frontend:
   ```bash
   cd frontend
   npm install
   npm start
   ```

## Notes

- Each service is a Spring Boot WebFlux application.
- Kafka topics drive inventory and supplier notifications.
- The frontend consumes the services over REST.
