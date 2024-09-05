package br.com.isaac.javarestawsdockerspringreactmockito.services.person;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.controllers.person.PersonController;
import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.mappers.CustomModelMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;
import br.com.isaac.javarestawsdockerspringreactmockito.repositories.PersonRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.RequiredObjectIsNullException;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.ResourceNotFoundException;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;

@Service
public class PersonService implements PersonServiceImpl {

  private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

  @Autowired
  private PersonRepository personRepository;

  @Override
  public List<PersonDTO> findAll() {
    logger.info("Finding all persons");

    List<PersonDTO> personsVo = CustomModelMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);

    // Add HATEOAS link to the PersonDTO
    personsVo.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

    return personsVo;
  }

  @Override
  public PersonDTO findById(Long id) {
    logger.info("Finding person with id: {}", id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(Constants.ID_NOT_FOUND + id));

    PersonDTO PersonDTO = CustomModelMapper.parseObject(entity, PersonDTO.class);

    // Add HATEOAS link to the PersonDTO
    PersonDTO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

    return PersonDTO;
  }

  @Override
  public PersonDTO create(PersonDTO person) {
    logger.info("Creating person: {}", person);

    if (person == null)
      throw new RequiredObjectIsNullException();

    Person entity = CustomModelMapper.parseObject(person, Person.class);
    PersonDTO PersonDTO = CustomModelMapper.parseObject(personRepository.save(entity), PersonDTO.class);

    // Add HATEOAS link to the PersonDTO
    PersonDTO.add(linkTo(methodOn(PersonController.class).findById(PersonDTO.getKey())).withSelfRel());

    return PersonDTO;
  }

  @Override
  public PersonDTO update(PersonDTO person) {
    logger.info("Updating person with id: {}", person.getKey());

    Person entity = personRepository.findById(person.getKey())
        .orElseThrow(() -> new ResourceNotFoundException(
            Constants.ID_NOT_FOUND + person.getKey()));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    PersonDTO PersonDTO = CustomModelMapper.parseObject(personRepository.save(entity), PersonDTO.class);

    // Adiciona o link HATEOAS ao PersonDTO
    PersonDTO.add(linkTo(methodOn(PersonController.class).findById(PersonDTO.getKey())).withSelfRel());

    return PersonDTO;
  }

  @Override
  public void delete(Long id) {
    logger.info("Deleting person with id: {}", id);

    Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(Constants.ID_NOT_FOUND + id));

    personRepository.delete(entity);
  }
}
