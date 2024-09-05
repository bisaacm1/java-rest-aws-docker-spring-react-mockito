package br.com.isaac.javarestawsdockerspringreactmockito.controllers.person;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.services.person.PersonService;

@RestController
@RequestMapping("api/person/v1")
public class PersonController implements IPersonController {

  private final PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<PersonDTO> findById(Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @Override
  public ResponseEntity<List<PersonDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @Override
  public ResponseEntity<PersonDTO> create(PersonDTO person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public ResponseEntity<PersonDTO> update(PersonDTO person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}