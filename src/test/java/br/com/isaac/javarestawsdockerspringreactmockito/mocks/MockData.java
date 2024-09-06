package br.com.isaac.javarestawsdockerspringreactmockito.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Book;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;

public class MockData {

    // Métodos para Person
    public Person createPersonEntity(int number) {
        Person person = new Person();
        person.setId((long) number); // Garante que o ID não seja nulo
        person.setFirstName("First Name Test " + number);
        person.setLastName("Last Name Test " + number);
        person.setAddress("Address Test " + number);
        person.setGender(number % 2 == 0 ? "Male" : "Female");
        return person;
    }

    public PersonDTO createPersonDTO(int number) {
        PersonDTO person = new PersonDTO();
        person.setKey((long) number); // Garante que a chave não seja nula
        person.setFirstName("First Name Test " + number);
        person.setLastName("Last Name Test " + number);
        person.setAddress("Address Test " + number);
        person.setGender(number % 2 == 0 ? "Male" : "Female");
        return person;
    }

    public List<Person> createPersonEntityList(int count) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            persons.add(createPersonEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> createPersonDTOList(int count) {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            persons.add(createPersonDTO(i));
        }
        return persons;
    }

    // Métodos para Book
    public Book createBookEntity(int number) {
        Book book = new Book();
        book.setId((long) number); // Garante que o ID não seja nulo
        book.setAuthor("Author Test " + number);
        book.setTitle("Title Test " + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        return book;
    }

    public BookDTO createBookDTO(int number) {
        BookDTO book = new BookDTO();
        book.setKey((long) number); // Garante que a chave não seja nula
        book.setAuthor("Author Test " + number);
        book.setTitle("Title Test " + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        return book;
    }

    public List<Book> createBookEntityList(int count) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(createBookEntity(i));
        }
        return books;
    }

    public List<BookDTO> createBookDTOList(int count) {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(createBookDTO(i));
        }
        return books;
    }
}
