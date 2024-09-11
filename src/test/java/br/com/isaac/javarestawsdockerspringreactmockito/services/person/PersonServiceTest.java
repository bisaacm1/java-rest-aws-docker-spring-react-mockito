package br.com.isaac.javarestawsdockerspringreactmockito.services.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.mocks.MockData;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repositories.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.RequiredObjectIsNullException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  private MockData mockData;

  @InjectMocks
  private PersonService service;

  @Mock
  private PersonRepository repository;

  @BeforeEach
  void setUp() {
    mockData = new MockData();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindById() {
    Person person = mockData.createPersonEntity(1);
    when(repository.findById(1L)).thenReturn(Optional.of(person));

    PersonDTO result = service.findById(1L);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
    assertEquals("Address Test 1", result.getAddress());
    assertEquals("First Name Test 1", result.getFirstName());
    assertEquals("Last Name Test 1", result.getLastName());
    assertEquals("Female", result.getGender());
  }

  @Test
  void testFindAll() {
    List<Person> people = mockData.createPersonEntityList(14);
    when(repository.findAll()).thenReturn(people);

    List<PersonDTO> result = service.findAll();

    assertNotNull(result);
    assertEquals(14, result.size());

    PersonDTO firstPerson = result.get(0);

    assertNotNull(firstPerson.getKey());
    assertNotNull(firstPerson.getLinks());
    assertEquals("Address Test 0", firstPerson.getAddress());
    assertEquals("First Name Test 0", firstPerson.getFirstName());
    assertEquals("Last Name Test 0", firstPerson.getLastName());
    assertEquals("Male", firstPerson.getGender());
  }

  @Test
  void testCreate() {
    Person persisted = mockData.createPersonEntity(1);
    persisted.setId(1L);
    PersonDTO dto = mockData.createPersonDTO(1);
    dto.setKey(1L);

    when(repository.save(any(Person.class))).thenReturn(persisted);

    PersonDTO result = service.create(dto);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
    assertEquals("Address Test 1", result.getAddress());
    assertEquals("First Name Test 1", result.getFirstName());
    assertEquals("Last Name Test 1", result.getLastName());
    assertEquals("Female", result.getGender());
  }

  @Test
  void testCreateWithNullPerson() {
    Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> service.create(null));

    String expectedMessage = "It is not allowed to persist a null object!";
    assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  void testUpdate() {
    Person entity = mockData.createPersonEntity(1);
    Person persisted = mockData.createPersonEntity(1);
    persisted.setId(1L);
    PersonDTO dto = mockData.createPersonDTO(1);
    dto.setKey(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(entity));
    when(repository.save(any(Person.class))).thenReturn(persisted);

    PersonDTO result = service.update(dto);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
    assertEquals("Address Test 1", result.getAddress());
    assertEquals("First Name Test 1", result.getFirstName());
    assertEquals("Last Name Test 1", result.getLastName());
    assertEquals("Female", result.getGender());
  }

  @Test
  void testDelete() {
    Person person = mockData.createPersonEntity(1);
    when(repository.findById(1L)).thenReturn(Optional.of(person));

    service.delete(1L);
  }
}
