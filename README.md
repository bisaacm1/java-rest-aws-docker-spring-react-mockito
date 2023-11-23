# Project Title: Creating a RESTful API with Spring Boot 3, Java 21, and Docker

## Description
This project is part of an Udemy course focusing on building RESTful APIs from scratch using Spring Boot 3, Java 21, and Docker. The primary objective of this project is to create a basic 'Hello World' REST API using these technologies and deploy it to Amazon Web Services (AWS).

## Tools and Technologies
- Spring Boot 3
- Java 21
- Docker
- Visual Studio Code (VSCode)
- Thunder Client (for API testing)
- Amazon Web Services (AWS)

## Project Setup
### Prerequisites
- Java 21 installed
- Docker installed
- AWS account created
- AWS CLI configured

### Steps to Deploy on AWS
1. Clone the repository: `git clone https://github.com/bisaacm1/java-rest-spring-boot`
2. Open the project in VSCode or your preferred IDE.
3. Configure AWS credentials and access keys using AWS CLI.
4. Containerize the application using Docker.
5. Push the Docker image to Amazon Elastic Container Registry (ECR).
6. Create an ECS (Elastic Container Service) cluster on AWS.
7. Deploy the Docker containerized application to ECS using ECS Fargate or ECS EC2 launch type.

## Project Structure
The project structure includes the following main components:
- `src/` - Contains the source code for the Spring Boot application.
- `pom.xml` - Maven configuration file.
- `Dockerfile` - Docker configuration for containerizing the application.
- `README.md` - Documentation file (you are here!).

## How to Use
After deploying the application to AWS, access the defined endpoints:
- `/hello` - Returns a simple "Hello, World!" message.

## Additional Notes
- During the course, the project was developed using VSCode and tested using Thunder Client for API endpoints.
- Deploying the application to AWS involves containerizing it with Docker and utilizing AWS services like ECS for deployment.

## AWS Services Used
- Amazon Elastic Container Registry (ECR)
- Amazon Elastic Container Service (ECS)

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Java SE Development Kit 21 Downloads](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Docker Documentation](https://docs.docker.com/)
- [AWS Documentation](https://docs.aws.amazon.com/)

## Author
Your Name

## License
This project is licensed under the MIT License - feel free to use, modify, and distribute it.
