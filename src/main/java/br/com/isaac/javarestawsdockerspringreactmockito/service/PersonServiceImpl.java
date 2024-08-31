package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

public interface PersonServiceImpl {

  PersonVO findById(Long value1);

  List<PersonVO> findAll();

  PersonVO create(PersonVO person);

  PersonVO update(PersonVO person);

  void delete(Long id);
}
