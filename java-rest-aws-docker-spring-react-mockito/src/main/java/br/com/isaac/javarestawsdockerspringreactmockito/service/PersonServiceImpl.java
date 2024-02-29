package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;

public interface PersonServiceImpl {

  Person findById(String value1);

  List<Person> findAll();

  Person create(Person person);

  Person update(Person person);

  void delete(String id);
}
