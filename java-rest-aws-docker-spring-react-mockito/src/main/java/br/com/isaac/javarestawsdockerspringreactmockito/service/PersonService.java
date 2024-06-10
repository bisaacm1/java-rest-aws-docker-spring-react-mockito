package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.ResourceNotFoundExepition;
import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repository.PersonRepository;

@Service
public class PersonService implements PersonServiceImpl {
  private final AtomicLong counter = new AtomicLong();

  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  @Override
  public Person findById(Long id) {
    logger.info("Finding one person with id: " + id);
    return personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!" + id));
  }

  @Override
  public List<Person> findAll() {
    logger.info("Finding all persons");
    return personRepository.findAll();
  }

  @Override
  public Person create(Person person) {
    logger.info("Create person: " + person);
    return personRepository.save(person);
  }

  @Override
  public Person update(Person person) {
    logger.info("Update person: " + person);

    Person entityPerson = personRepository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!"));

    entityPerson.setFirstName(person.getFirstName());
    entityPerson.setLastName(person.getLastName());
    entityPerson.setAddress(person.getAddress());
    entityPerson.setGender(person.getGender());

    return personRepository.save(person);
  }

  @Override
  public void delete(Long id) {
    logger.info("Delete one person with id: " + id);

    var entityPerson = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!"));

    personRepository.delete(entityPerson);
  }
}
