# 🌐 **Java REST API with Spring Boot**

## 📝 **Project Overview**

Welcome to my demo project! 🚀 This Spring Boot-based RESTful API is built with best practices in mind, leveraging powerful tools and technologies like MySQL, Flyway, ModelMapper, and Swagger. Although AWS and Docker configurations aren't included yet, this project provides a strong starting point for building robust and maintainable applications.

---

## 🛠 **Tech Stack & Tools**

Here's a rundown of the core tools and technologies used in this project:

- **Spring Boot**: 3.0.1 🚀
- **Java**: 18 ☕️
- **MySQL**: 8.0.33 🗄
- **Flyway**: 8.x 🔄
- **ModelMapper**: 3.2.0 🗺
- **JUnit 5**: 5.x ✅
- **Lombok**: 1.18.22 ✨
- **Swagger (Springdoc OpenAPI)**: 2.0.2 📜
- **SLF4J and Logback**: Logging 🔍
- **TestContainers**: 1.16.3 🧪
- **Rest Assured**: 4.5.0 🌐

---

## ⚙️ **Getting Started**

### **Prerequisites**

Before diving in, ensure that you have the following installed:

- ☕️ **Java 18**: [Download Java 18](https://www.oracle.com/java/technologies/javase-jdk18-downloads.html)
- 🗄 **MySQL**: Set it up locally or via a cloud database service.

### **Clone the Repository**

Ready to jump in? Clone the repository with the following command:

```bash
git clone https://github.com/bisaacm1/java-rest-aws-docker-spring-react-mockito
```

### **Build and Run**

Once you've cloned the repository, navigate to the project directory and build the project:

```bash
cd java-rest-aws-docker-spring-react-mockito
./mvnw clean install
```

Now, run the Spring Boot application:

```bash
./mvnw spring-boot:run
```

---

## 📜 **Swagger API Documentation**

Explore the API seamlessly with Swagger! Once the application is running, you can access the Swagger UI by navigating to:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Swagger provides interactive API documentation, allowing you to test endpoints directly from the UI. 🎯

---

## 🔄 **Database Migration with Flyway**

Database migrations are a breeze with Flyway. Just place your migration scripts in the `src/main/resources/db/migration` directory, and Flyway will automatically apply them when the application starts. 🔄

---

## 🛠 **Project Structure**

The project is organized into the following key directories:

- **controllers**: Handles HTTP requests.
  - `book`: Endpoints for book-related operations.
  - `person`: Endpoints for person-related operations.
- **dtos**: Data Transfer Objects for encapsulating data. 📦
- **mappers**: Model mapping (e.g., `CustomModelMapper`). 🗺
- **models**: Domain models representing entities (e.g., `Book`). 📚
- **repositories**: Interfaces for database interactions. 🔍
- **services**: Implements business logic and services.
  - `book`: Services related to books. 📖
  - `person`: Services related to people. 🧑‍🤝‍🧑
- **shared**: Common utilities, configurations, exceptions, and serializers. 🔧
- **resources-collections**: Postman and ThunderClient collections for API testing. 📑

---

## 📁 **Postman and Thunder Client Collections**

To facilitate testing the API, we've included pre-configured collections for both Postman and Thunder Client in the `resources-collections` folder. You can easily import these into your preferred tool to get started with the available endpoints.

- **Postman Collection**: Located in `resources-collections/postman_collection.json`
- **Thunder Client Collection**: Located in `resources-collections/thunderclient_collection.json`

These collections use dynamic variables like `{{baseUrl}}` for flexibility. Make sure to set up your environment variables or replace `{{baseUrl}}` with your actual server address (e.g., `http://localhost:8080`).

---

## 🔍 **Testing**

Testing is essential to ensure the stability and reliability of your code. This project utilizes **JUnit 5**, **Mockito**, **TestContainers**, and **Rest Assured** for comprehensive testing:

Run tests with:

```bash
./mvnw test
```

---

## 🚀 **Future Enhancements**

There are several enhancements planned for the future:

- 🐳 **Docker Integration**: Containerize the application for consistent and scalable deployment.
- ☁️ **AWS Setup**: Deploy to AWS with S3, RDS, and other cloud services.
- 🧑‍💻 **CI/CD Pipeline**: Automate the build and deployment process using GitHub Actions or Jenkins.

---

## 📝 **License**

This project is licensed under the MIT License. For more details, refer to the [LICENSE](LICENSE) file. 📜

---

## 📞 **Contact**

If you have any questions or would like to discuss this project further, feel free to reach out to me:

- 📧 **Email**: [isaacbmaciel@gmail.com](mailto:isaacbmaciel@gmail.com)
- 🔗 **LinkedIn**: [Isaac Batista Maciel](https://www.linkedin.com/in/isaac-batista-maciel/)
- 💻 **GitHub**: [bisaacm1](https://github.com/bisaacm1)

Looking forward to connecting with you! 😊
