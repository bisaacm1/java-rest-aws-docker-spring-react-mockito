package br.com.isaac.javarestawsdockerspringreactmockito.service;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.RequiredObjextIsNullException;
import br.com.isaac.javarestawsdockerspringreactmockito.mocks.MockPerson;
import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repository.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(PersonServiceTest.class);

  private MockPerson input;

  @InjectMocks
  private PersonService service;

  @Mock
  private PersonRepository repository;

  @BeforeEach
  void setUp() {
    input = new MockPerson();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindById() {
    Person person = input.mockEntity();
    person.setId(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(person));

    PersonVO result = service.findById(1L);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
    assertEquals("Addres Test0", result.getAddress());
    assertEquals("First Name Test0", result.getFirstName());
    assertEquals("Last Name Test0", result.getLastName());
    assertEquals("Male", result.getGender());
  }

  @Test
  void testFindAll() {
    List<Person> person = input.mockEntityList();

    when(repository.findAll()).thenReturn(person);

    List<PersonVO> result = service.findAll();

    assertNotNull(result);
    assertEquals(14, result.size());

    PersonVO resultList = result.get(0);

    assertNotNull(resultList.getKey());
    assertNotNull(resultList.getLinks());
    assertEquals("Addres Test0", resultList.getAddress());
    assertEquals("First Name Test0", resultList.getFirstName());
    assertEquals("Last Name Test0", resultList.getLastName());
    assertEquals("Male", resultList.getGender());
  }

  @Test
  void testCreate() {
    Person entity = input.mockEntity();

    Person persisted = entity;
    persisted.setId(1L);

    PersonVO vo = input.mockVO(1);
    vo.setKey(1L);

    when(repository.save(any(Person.class))).thenReturn(persisted);

    PersonVO result = service.create(vo);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
    assertEquals("Addres Test0", result.getAddress());
    assertEquals("First Name Test0", result.getFirstName());
    assertEquals("Last Name Test0", result.getLastName());
    assertEquals("Male", result.getGender());
  }

  @Test
  void testCreateWithNullPerson() {
    Exception exception = assertThrows(RequiredObjextIsNullException.class, () -> {
      service.create(null);
    });

    String expectedMessage = "It is not allowed to persist a null object!";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void testUpdate() {
    Person entity = input.mockEntity();
    entity.setId(1L);

    Person persisted = entity;
    persisted.setId(1L);

    PersonVO vo = input.mockVO(1);
    vo.setKey(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(entity));
    when(repository.save(any(Person.class))).thenReturn(persisted);

    PersonVO result = service.update(vo);

    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
    assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
    assertEquals("Addres Test1", result.getAddress());
    assertEquals("First Name Test1", result.getFirstName());
    assertEquals("Last Name Test1", result.getLastName());
    assertEquals("Female", result.getGender());
  }

  @Test
  void testDelete() {
    Person person = input.mockEntity();
    person.setId(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(person));

    service.delete(1L);
  }
}
