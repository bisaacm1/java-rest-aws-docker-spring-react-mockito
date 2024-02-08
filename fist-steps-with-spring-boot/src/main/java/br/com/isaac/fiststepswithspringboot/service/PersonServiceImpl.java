package br.com.isaac.fiststepswithspringboot.service;

import java.util.List;

import br.com.isaac.fiststepswithspringboot.model.Person;

public interface PersonServiceImpl {

  Person findById(String value1);

  List<Person> findAll();

}
