package br.com.isaac.javarestawsdockerspringreactmockito.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Book;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;

public class CustomModelMapper {

  private static ModelMapper mapper = new ModelMapper();

  static {
    // Mapeamento para Person e PersonDTO
    mapper.createTypeMap(Person.class, PersonDTO.class)
        .addMapping(Person::getId, PersonDTO::setKey);

    mapper.createTypeMap(PersonDTO.class, Person.class)
        .addMapping(PersonDTO::getKey, Person::setId);

    // Mapeamento para Book e BookDTO
    mapper.createTypeMap(Book.class, BookDTO.class)
        .addMapping(Book::getId, BookDTO::setKey)
        .addMapping(Book::getLaunchDate, BookDTO::setLaunchDate);

    mapper.createTypeMap(BookDTO.class, Book.class)
        .addMapping(BookDTO::getKey, Book::setId)
        .addMapping(BookDTO::getLaunchDate, Book::setLaunchDate);
  }

  public static <O, D> D parseObject(O origin, Class<D> destination) {
    return mapper.map(origin, destination);
  }

  public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
    List<D> destinationObjects = new ArrayList<>();
    for (O o : origin) {
      destinationObjects.add(mapper.map(o, destination));
    }
    return destinationObjects;
  }
}
