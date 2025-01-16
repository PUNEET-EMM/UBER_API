 Uber Backend System

A scalable backend system for a ride-sharing application inspired by Uber. This project manages riders, drivers, and authentication using Spring Boot and exposes APIs for all critical operations.

## Features

- **Rider Functionality**:
  - Request a ride
  - Rate a driver
  - Cancel a ride
  - View ride history and profile details

- **Driver Functionality**:
  - Start and end a ride
  - Accept or cancel ride requests
  - Rate riders
  - View ride history and profile details

- **Authentication**:
  - User signup and login
  - Refresh tokens
  - Onboarding new drivers

## API Documentation

The API documentation is available via Swagger. Access the Swagger UI at:

``` (http://localhost:8080/swagger-ui/index.html)```



### Key Endpoints

#### Rider Controller

| Method | Endpoint                                  | Description                |
|--------|------------------------------------------|----------------------------|
| POST   | `/rider/rideRequest`                     | Request a ride             |
| POST   | `/rider/rateDriver/{rideId}/{rating}`    | Rate a driver              |
| POST   | `/rider/cancelRide/{rideId}`             | Cancel a ride              |
| GET    | `/rider/getMyRides`                      | Get ride history           |
| GET    | `/rider/getMyProfile`                    | View profile details       |

#### Driver Controller

| Method | Endpoint                                  | Description                |
|--------|------------------------------------------|----------------------------|
| POST   | `/drivers/startRide/{rideRequestId}`     | Start a ride               |
| POST   | `/drivers/endRide/{rideId}`              | End a ride                 |
| POST   | `/drivers/cancelRide/{rideId}`           | Cancel a ride              |
| POST   | `/drivers/rateRider/{rideId}/{rating}`   | Rate a rider               |
| POST   | `/drivers/acceptRide/{rideRequestId}`    | Accept a ride request      |
| GET    | `/drivers/getMyRides`                    | Get ride history           |
| GET    | `/drivers/getMyProfile`                  | View profile details       |

#### Authentication Controller

| Method | Endpoint                                  | Description                |
|--------|------------------------------------------|----------------------------|
| POST   | `/auth/signup`                           | User signup                |
| POST   | `/auth/login`                            | User login                 |
| POST   | `/auth/refresh`                          | Refresh authentication token |
| POST   | `/auth/onBoardNewDriver/{userId}`        | Onboard a new driver       |

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/UBER_API.git
   cd Folder_name``


2. Run the application:

```mvn spring-boot:run```

3. Access the Swagger UI at:

```http://localhost:8080/swagger-ui/index.html```
Configuration

Add the following configuration to the application.properties file for the proper setup:

# Application configuration
spring.application.name=uberApi

# Database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/demoDB?useSSL=false
spring.datasource.username=demoUser
spring.datasource.password=demoPassword
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Data initialization
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql

# JWT configuration
jwt.secretKey=demoSecretKey1234567890

# SMTP configuration
spring.mail.username=your-email@example.com
spring.mail.password=your-email-password
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
