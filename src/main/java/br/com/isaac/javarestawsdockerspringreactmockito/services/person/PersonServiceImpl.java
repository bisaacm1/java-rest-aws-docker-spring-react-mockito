package br.com.isaac.javarestawsdockerspringreactmockito.services.person;

import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;

public interface PersonServiceImpl {

  PersonDTO findById(Long value1);

  List<PersonDTO> findAll();

  PersonDTO create(PersonDTO person);

  PersonDTO update(PersonDTO person);

  void delete(Long id);
}
