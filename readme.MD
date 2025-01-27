# Demo Multi-Context Application

This is a multi-context Spring Boot application that demonstrates the use of separate application contexts for handling
different parts of a system. The application consists of two independent contexts:

- **Components Context**: Manages components with a MySQL database.
- **Orders Context**: Handles orders with a PostgreSQL database.

## Application Structure

- **Components Context**: Implements endpoints for managing components.
- **Orders Context**: Implements endpoints for managing orders.
- Both contexts run as part of the same Spring Boot application and can be independently started

### Key Technologies

- Java 17
- Spring Boot 3.4.1
- Spring Data JDBC
- Flyway for database migrations
- Docker Compose for database infrastructure

## Build Instructions

1. Ensure you have Java 17 and Gradle installed.
2. Clone the repository:
   ```bash
   git clone https://github.com/belyaev-andrey/demo-multi-context.git
   cd demo-multi-context
   ```
3. Build the project:
   ```bash
   ./gradlew clean build
   ```

## Run Instructions

1. Run the application:
    - To start the **Application with both contexts**:
      ```bash
      ./gradlew bootRun 
      ```
    - Databases will start automatically using built-in Docker Compose integration 

## Application Endpoints

- **Components Context**:
    - Base URL: `http://localhost:8080`
    - API Endpoints:
        - `GET /api/components`: Fetch all components.

- **Orders Context**:
    - Base URL: `http://localhost:8081`
    - API Endpoints:
        - `GET /api/orders`: Fetch all orders.

## Database Configuration

The application uses MySQL and PostgreSQL databases, configured automatically.

### MySQL (Components Context)

- **URL**: `jdbc:mysql://localhost:3307/components`
- **Username**: `components`
- **Password**: `components`

### PostgreSQL (Orders Context)

- **URL**: `jdbc:postgresql://localhost:5433/orders`
- **Username**: `orders`
- **Password**: `orders`

Databases are set up using Flyway migrations. 

## Testing

Tests are written using Spring Boot Test and Testcontainers. Run the tests using:

```bash
./gradlew test
```

## Dependencies

The project uses the following dependencies:

- Spring Boot frameworks for web, data access, and actuator endpoints.
- Flyway for database schema management.
- Testcontainers for testing with containerized databases.
- MySQL and PostgreSQL drivers for JDBC database access.
