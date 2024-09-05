package br.com.isaac.javarestawsdockerspringreactmockito.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

  // URL da interface Swagger UI: http://localhost:8080/swagger-ui/index.html
  // URL da documentação OpenAPI-JSON: http://localhost:8080/v3/api-docs
  // URL da documentação OpenAPI-YAML: http://localhost:8080/v3/api-docs.yaml

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("RESTful API with Spring Boot, Docker, and AWS")
            .version("v1")
            .description(
                "Este projeto é uma aplicação demo construída com Spring Boot. O objetivo é criar uma API RESTful com integração ao MySQL, utilizando Docker para containerização, testes com JUnit 5, e automação de migrações de banco de dados com Flyway. Além disso, o projeto é configurado para ser implantado na AWS.")
            .termsOfService("https://pub.erudio.com.br/meus-cursos")
            .license(
                new License()
                    .name("Apache 2.0")
                    .url("https://github.com/bisaacm1/java-rest-aws-docker-spring-react-mockito")));
  }

}
