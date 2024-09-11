package br.com.isaac.javarestawsdockerspringreactmockito.controllers.person;

import static br.com.isaac.javarestawsdockerspringreactmockito.mocks.MockData.mockPersonDTO;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.integration.AbstractIntegrationTest;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PersonControllerTest extends AbstractIntegrationTest {

  private static final String BASE_PATH = "/api/person/v1";
  private static RequestSpecification specification;
  private static ObjectMapper objectMapper;

  @BeforeAll
  public static void setup() {
    objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    // Initialize the RequestSpecification
    initializeSpecification(Constants.ORIGIN_ISAAC);
  }

  private static void initializeSpecification(String origin) {
    specification = new RequestSpecBuilder()
        .addHeader(Constants.HEADER_PARAM_ORIGIN, origin)
        .setBasePath(BASE_PATH)
        .setPort(Constants.SERVER_PORT)
        .addFilter(new RequestLoggingFilter(LogDetail.ALL))
        .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
        .build();
  }

  @Test
  @Order(1)
  public void shouldCreatePerson() throws JsonProcessingException {
    PersonDTO person = mockPersonDTO();
    initializeSpecification(Constants.ORIGIN_ISAAC);

    var response = given().spec(specification)
        .contentType(Constants.APPLICATION_JSON)
        .body(person)
        .when()
        .post()
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString();

    PersonDTO persistedPerson = objectMapper.readValue(response, PersonDTO.class);
    validatePerson(persistedPerson);
  }

  @Test
  @Order(2)
  public void shouldFailCreatePersonWithWrongOrigin() {
    PersonDTO person = mockPersonDTO();
    initializeSpecification(Constants.ORIGIN_ISAAC_TEST_FAIL);

    var response = given().spec(specification)
        .contentType(Constants.APPLICATION_JSON)
        .body(person)
        .when()
        .post()
        .then()
        .statusCode(403)
        .extract()
        .body()
        .asString();

    assertEquals("Invalid CORS request", response);
  }

  @Test
  @Order(3)
  public void shouldFindPersonById() throws JsonProcessingException {
    PersonDTO person = mockPersonDTO();
    initializeSpecification(Constants.ORIGIN_ISAAC);

    var response = given().spec(specification)
        .contentType(Constants.APPLICATION_JSON)
        .pathParam("id", person.getKey())
        .when()
        .get("{id}")
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString();

    PersonDTO persistedPerson = objectMapper.readValue(response, PersonDTO.class);
    validatePerson(persistedPerson);
  }

  @Test
  @Order(4)
  public void shouldFailFindPersonByIdWithWrongOrigin() {
    PersonDTO person = mockPersonDTO();
    initializeSpecification(Constants.ORIGIN_ISAAC_TEST_FAIL);

    var response = given().spec(specification)
        .contentType(Constants.APPLICATION_JSON)
        .pathParam("id", person.getKey())
        .when()
        .get("{id}")
        .then()
        .statusCode(403)
        .extract()
        .body()
        .asString();

    assertEquals("Invalid CORS request", response);
  }

  private void validatePerson(PersonDTO person) {
    assertNotNull(person);
    assertNotNull(person.getKey());
    assertNotNull(person.getFirstName());
    assertNotNull(person.getLastName());
    assertNotNull(person.getAddress());
    assertNotNull(person.getGender());
    assertTrue(person.getKey() > 0);

    assertEquals("Richard", person.getFirstName());
    assertEquals("Stallman", person.getLastName());
    assertEquals("New York City, New York, US", person.getAddress());
    assertEquals("Male", person.getGender());
  }
}
