package br.com.isaac.fiststepswithspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.isaac.fiststepswithspringboot.model.Person;

public interface IPersonController {

  @GetMapping(value = "/{id}")
  public ResponseEntity<Person> findByid(@PathVariable String id);

  @GetMapping(value = "/all")
  public ResponseEntity<List<Person>> findAll();

}