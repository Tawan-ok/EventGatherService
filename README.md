# EventGatherService

EventGatherService is a backend service designed to power a community-based web application that allows users to create and join events, such as playing basketball, attending workshops, or participating in other community activities. This service is built using Java Spring Boot and integrates with MongoDB for data persistence.

---

## Features

### User Management
- Create, update, delete, and retrieve user information.
- Maintain user preferences and details such as name, email, password, etc.

### Event Management
- Create and manage community events.
- Allow users to join or leave events.

### Community Features
- Enable collaboration and participation through event-based engagement.
- User-friendly API endpoints to facilitate seamless integration with frontend services.

### Scalable Architecture
- Built with Spring Boot to ensure modularity and scalability.
- Uses MongoDB for a flexible and high-performance database.

### Integration Testing
- Incorporates integration tests using Testcontainers to ensure MongoDB compatibility without affecting production.

---

## Technology Stack

### Backend
- **Spring Boot**: Provides the framework for building the service.
- **MongoDB**: NoSQL database for flexible data management.
- **Lombok**: Reduces boilerplate code for entity models.
- **Swagger/OpenAPI**: Auto-generates API documentation.

### Testing
- **Spock Framework**: For unit and integration testing.
- **Testcontainers**: For running MongoDB containers during integration testing.

---

## Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher.
- **MongoDB**: Ensure MongoDB is running on the default port (27017). Alternatively, use Docker to spin up a MongoDB container:
  ```bash
  docker run -d --name mongodb -p 27017:27017 mongo:6.0.6


- **Gradle**: For building the project.

- **Docker**: Required for running Testcontainers.

## Setup

## Clone the Repository

```bash
git clone https://github.com/yourusername/EventGatherService.git
cd EventGatherService
```

---

## Configure Environment

Update the following properties in `application.properties` to connect to your MongoDB instance:
```properties
spring.application.name=EventGatherService
spring.data.mongodb.uri=mongodb://localhost:27017/eventgather
```

---

## Build the Project
```bash
./gradlew build
```

---

## Run the Application
```bash
./gradlew bootRun
```

The service will start on [http://localhost:8080](http://localhost:8080).

---

## API Endpoints

### User Management

#### Get All Users
**GET** `/users/get-all-users`

#### Get User by ID
**GET** `/users/get-user?id={userId}`

#### Create a User
**POST** `/users/create`

**Request Body:**
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "securepassword"
}
```

#### Update a User
**PUT** `/users/update/{id}`

**Request Body:**
```json
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "password": "newpassword"
}
```

#### Delete a User
**DELETE** `/users/delete?id={userId}`

---

## Testing

### Run Unit Tests
```bash
./gradlew test
```

### Integration Testing with Testcontainers
The project uses Testcontainers to run MongoDB in a Docker container for integration tests. Ensure Docker is running on your system before executing:
```bash
./gradlew test
```

---

## Contribution

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to the branch and create a pull request.

---

## License

This project is licensed under the MIT License. See the LICENSE file for details.
