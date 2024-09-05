# 🌐 **Java REST API with Spring Boot**

## 📝 **Description**

Welcome to this demo project built with Spring Boot! 🚀 The aim here is to create a RESTful API using Spring Boot, MySQL, and various awesome tools like Swagger, Flyway, and ModelMapper. Note that AWS and Docker configurations are not yet included in this project.

---

## 🛠 **Tools and Technologies**

- **Spring Boot**: 2.6.3
- **Java**: 17 ☕️
- **MySQL**: 8.0.33 🗄
- **Flyway**: 7.15.0 🔄
- **ModelMapper**: 3.2.0 🗺
- **JUnit 5**: 5.8.2 ✅
- **Lombok**: 1.18.22 ✨
- **Swagger (Springdoc OpenAPI)**: 1.6.15 📜
- **SLF4J and Logback**: For logging 🔍

---

## ⚙️ **Project Setup**

### **Prerequisites**

Before you dive in, make sure you have the following tools installed:

- ☕️ **Java 17**: [Download Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- 🗄 **MySQL**: Install it locally or set up an instance on a database server.

### **Clone the Repository**

Ready to start? Clone the repository with:

```bash
git clone https://github.com/bisaacm1/java-rest-aws-docker-spring-react-mockito
```

### **Build and Run the Project**

Navigate to the project directory:

```bash
cd java-rest-aws-docker-spring-react-mockito
```

Compile and run the project:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

### 📜 **Swagger Documentation**

Explore the API easily with Swagger UI! After starting the application, open Swagger UI at:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

It offers interactive documentation and lets you test API endpoints directly. 🎯

### 🔄 **Database Migration with Flyway**

Flyway handles database migrations for you. Place your migrations in the `src/main/resources/db/migration` directory. Flyway will automatically apply any pending migrations when the app starts. 🔄

---

## 🛠 **Project Structure**

Here's how the project is organized:

- **controllers**: Manages HTTP requests.
  - `book`: Endpoints for book-related operations.
  - `person`: Endpoints for person-related operations.
- **dtos**: Data Transfer Objects for data encapsulation. 📦
- **mappers**: For model mapping (e.g., CustomModelMapper). 🗺
- **models**: Domain models representing entities (e.g., Book). 📚
- **repositories**: Interfaces for data access. 🔍
- **services**: Business logic and service layer.
  - `book`: Services related to books. 📖
  - `person`: Services related to people. 🧑‍🤝‍🧑
- **shared**: Common utilities, configuration, exceptions, and serializers. 🔧

### 🔍 **Testing**

Run tests with JUnit 5 and Mockito using:

```bash
./mvnw test
```

---

## 📝 **License**

This project is licensed under the MIT License. Check out the LICENSE file for details. 📜

### 📞 **Contact**

Got questions or need support? Reach out to me:

- 📧 Email: [isaacbmaciel@gmail.com](mailto:isaacbmaciel@gmail.com)
- 🔗 LinkedIn: [Isaac Batista Maciel](https://www.linkedin.com/in/isaac-batista-maciel/)
- 💻 GitHub: [bisaacm1/java-rest-aws-docker-spring-react-mockito](https://github.com/bisaacm1/java-rest-aws-docker-spring-react-mockito)
