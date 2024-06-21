package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.vo.v1.PersonVO;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.v2.PersonVOV2;

public interface PersonServiceImpl {

  PersonVO findById(Long value1);

  List<PersonVO> findAll();

  PersonVO create(PersonVO person);

  PersonVOV2 createV2(PersonVOV2 person);

  PersonVO update(PersonVO person);

  void delete(Long id);
}
