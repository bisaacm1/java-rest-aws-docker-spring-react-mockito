package br.com.isaac.javarestawsdockerspringreactmockito.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController implements IPersonController {

  private final PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Person> findByid(String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @Override
  public ResponseEntity<List<Person>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @Override
  public ResponseEntity<Person> create(Person person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public ResponseEntity<Person> update(Person person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public void delete(String id) {
    service.delete(id);
  }
}