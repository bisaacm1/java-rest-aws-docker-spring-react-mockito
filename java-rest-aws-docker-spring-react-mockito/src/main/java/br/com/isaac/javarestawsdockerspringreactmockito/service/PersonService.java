package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;

@Service
public class PersonService implements PersonServiceImpl {
  private final AtomicLong counter = new AtomicLong();

  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Override
  public Person findById(String id) {
    logger.info("Finding one person with id: " + id);
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Isaac");
    person.setLastName("Batista");
    person.setAddress("Osasco - Sao Paulo - Brasil");
    person.setGender("Male");
    return person;
  }

  @Override
  public List<Person> findAll() {
    logger.info("Finding all persons");
    List<Person> persons = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      Person person = mockPerson(i);
      persons.add(person);
    }
    return persons;
  }

  private Person mockPerson(int i) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Name: " + i);
    person.setLastName("Last Name: " + i);
    person.setAddress("Address: " + i);
    person.setGender("Male");
    return person;
  }

  @Override
  public Person create(Person person) {
    logger.info("Create person: " + person);
    return person;
  }

  @Override
  public Person update(Person person) {
    logger.info("Update person: " + person);
    return person;
  }

  @Override
  public void delete(String id) {
    logger.info("Delete one person with id: " + id);
  }
}
