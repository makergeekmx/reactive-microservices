# Reactive Microservices Demo

This workspace contains a multi-service demo built with Spring Boot WebFlux, Kafka, and a React frontend.

Services:
- `product-service` — products and categories CRUD.
- `inventory-service` — inventory management and in/out notifications.
- `supplier-service` — suppliers and supplier order management.
- `user-service` — user management.
- `notification-service` — Kafka-driven notification delivery and event consumer.
- `frontend` — React UI with Material UI and Axios for cross-service dashboards.

## Project Structure

- `product-service` — service for products and categories CRUD.
- `inventory-service` — service for inventory management and Kafka inventory events.
- `supplier-service` — service for supplier records and supplier order events.
- `user-service` — service for user account CRUD operations.
- `notification-service` — Kafka consumer that logs inventory and supplier notifications.
- `frontend` — React dashboard consuming all backend services.

## Frontend Documentation

The frontend is built with React, Vite, Material UI, and Axios. It shows:
- Product catalog cards
- Inventory status
- Supplier list
- User list

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
