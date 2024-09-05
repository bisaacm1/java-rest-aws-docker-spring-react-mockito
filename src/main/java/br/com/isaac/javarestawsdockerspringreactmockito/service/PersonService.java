package br.com.isaac.javarestawsdockerspringreactmockito.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.controller.PersonController;
import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.RequiredObjextIsNullException;
import br.com.isaac.javarestawsdockerspringreactmockito.exceptions.ResourceNotFoundException;
import br.com.isaac.javarestawsdockerspringreactmockito.mapper.CustomModelMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.model.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repository.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.utils.Constants;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

@Service
public class PersonService implements PersonServiceImpl {

  private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

  @Autowired
  private PersonRepository personRepository;

  @Override
  public List<PersonVO> findAll() {
    logger.info("Finding all persons");

    List<PersonVO> personsVo = CustomModelMapper.parseListObjects(personRepository.findAll(), PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personsVo.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

    return personsVo;
  }

  @Override
  public PersonVO findById(Long id) {
    logger.info("Finding person with id: {}", id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(Constants.ID_NOT_FOUND + id));

    PersonVO personVo = CustomModelMapper.parseObject(entity, PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

    return personVo;
  }

  @Override
  public PersonVO create(PersonVO person) {
    logger.info("Creating person: {}", person);

    if (person == null)
      throw new RequiredObjextIsNullException();

    Person entity = CustomModelMapper.parseObject(person, Person.class);
    PersonVO personVo = CustomModelMapper.parseObject(personRepository.save(entity), PersonVO.class);

    // Add HATEOAS link to the PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());

    return personVo;
  }

  @Override
  public PersonVO update(PersonVO person) {
    logger.info("Updating person with id: {}", person.getKey());

    Person entity = personRepository.findById(person.getKey())
        .orElseThrow(() -> new ResourceNotFoundException(
            Constants.ID_NOT_FOUND + person.getKey()));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    PersonVO personVo = CustomModelMapper.parseObject(personRepository.save(entity), PersonVO.class);

    // Adiciona o link HATEOAS ao PersonVO
    personVo.add(linkTo(methodOn(PersonController.class).findById(personVo.getKey())).withSelfRel());

    return personVo;
  }

  @Override
  public void delete(Long id) {
    logger.info("Deleting person with id: {}", id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(Constants.ID_NOT_FOUND + id));

    personRepository.delete(entity);
  }
}
