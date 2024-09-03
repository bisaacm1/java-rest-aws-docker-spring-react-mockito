﻿package br.com.isaac.javarestawsdockerspringreactmockito.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.controller.PersonController;
import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.ResourceNotFoundException;
import br.com.isaac.javarestawsdockerspringreactmockito.mapper.DozerMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repository.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

@Service
public class PersonService implements PersonServiceImpl {

  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  @Override
  public List<PersonVO> findAll() {
    logger.info("Finding all persons");

    List<PersonVO> personsVo = DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personsVo
        .stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

    return personsVo;
  }

  @Override
  public PersonVO findById(Long id) {
    logger.info("Finding one person with id: " + id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!" + id));

    PersonVO personVo = DozerMapper.parseObject(entity, PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

    return personVo;

  }

  @Override
  public PersonVO create(PersonVO person) {
    logger.info("Create person: " + person);
    Person entity = DozerMapper.parseObject(person, Person.class);
    PersonVO personVo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());

    return personVo;
  }

  @Override
  public PersonVO update(PersonVO person) {
    logger.info("Update person: " + person);

    Person entityPersonVO = personRepository.findById(person.getKey())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

    entityPersonVO.setFirstName(person.getFirstName());
    entityPersonVO.setLastName(person.getLastName());
    entityPersonVO.setAddress(person.getAddress());
    entityPersonVO.setGender(person.getGender());

    PersonVO personVo = DozerMapper.parseObject(personRepository.save(entityPersonVO), PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());

    return personVo;
  }

  @Override
  public void delete(Long id) {
    logger.info("Delete one person with id: " + id);

    var entityPersonVO = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

    personRepository.delete(entityPersonVO);
  }
}
