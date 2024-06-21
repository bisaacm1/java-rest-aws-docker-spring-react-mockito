﻿package br.com.isaac.javarestawsdockerspringreactmockito.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.ResourceNotFoundExepition;
import br.com.isaac.javarestawsdockerspringreactmockito.mapper.DozerMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.mapper.PersonMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repository.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.v1.PersonVO;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.v2.PersonVOV2;

@Service
public class PersonService implements PersonServiceImpl {

  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  @Autowired
  PersonMapper personMapper;

  @Override
  public List<PersonVO> findAll() {
    logger.info("Finding all persons");
    return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
  }

  @Override
  public PersonVO findById(Long id) {
    logger.info("Finding one person with id: " + id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!" + id));

    return DozerMapper.parseObject(entity, PersonVO.class);

  }

  @Override
  public PersonVO create(PersonVO person) {
    logger.info("Create person: " + person);
    Person entity = DozerMapper.parseObject(person, Person.class);
    PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

    return vo;
  }

  @Override
  public PersonVO update(PersonVO person) {
    logger.info("Update person: " + person);

    Person entityPersonVO = personRepository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!"));

    entityPersonVO.setFirstName(person.getFirstName());
    entityPersonVO.setLastName(person.getLastName());
    entityPersonVO.setAddress(person.getAddress());
    entityPersonVO.setGender(person.getGender());

    PersonVO vo = DozerMapper.parseObject(personRepository.save(entityPersonVO), PersonVO.class);
    return vo;
  }

  @Override
  public void delete(Long id) {
    logger.info("Delete one person with id: " + id);

    var entityPersonVO = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExepition("No records found for this id!"));

    personRepository.delete(entityPersonVO);
  }

  @Override
  public PersonVOV2 createV2(PersonVOV2 person) {
    logger.info("Create person: " + person);
    Person entity = personMapper.convertVoToEntity(person);
    PersonVOV2 vo = personMapper.convertEntityToVo(entity);

    return vo;
  }
}
