package br.com.isaac.fiststepswithspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.fiststepswithspringboot.model.Person;
import br.com.isaac.fiststepswithspringboot.service.PersonService;

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

}
