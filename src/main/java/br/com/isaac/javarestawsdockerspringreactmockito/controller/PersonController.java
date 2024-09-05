package br.com.isaac.javarestawsdockerspringreactmockito.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.javarestawsdockerspringreactmockito.service.PersonService;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

@RestController
@RequestMapping("api/person/v1")
public class PersonController implements IPersonController {

  private final PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<PersonVO> findById(Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @Override
  public ResponseEntity<List<PersonVO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @Override
  public ResponseEntity<PersonVO> create(PersonVO person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public ResponseEntity<PersonVO> update(PersonVO person) {
    return ResponseEntity.ok(service.create(person));
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}