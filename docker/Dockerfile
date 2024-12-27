# Use uma imagem base do OpenJDK
FROM openjdk:18-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o container
COPY target/java-rest-aws-docker-spring-react-mockito-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que o Spring Boot usará
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
