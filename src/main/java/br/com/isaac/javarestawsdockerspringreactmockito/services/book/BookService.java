package br.com.isaac.javarestawsdockerspringreactmockito.services.book;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isaac.javarestawsdockerspringreactmockito.controllers.book.BookController;
import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.mappers.CustomModelMapper;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Book;
import br.com.isaac.javarestawsdockerspringreactmockito.repositories.BookRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.RequiredObjectIsNullException;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.ResourceNotFoundException;

@Service
public class BookService implements BookServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookRepository repository;

	@Override
	public List<BookDTO> findAll() {
		logger.info("Finding all books");

		List<BookDTO> books = repository.findAll()
				.stream()
				.map(book -> CustomModelMapper.parseObject(book, BookDTO.class))
				.collect(Collectors.toList());

		books.forEach(
				bookDTO -> bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getKey())).withSelfRel()));

		return books;
	}

	@Override
	public BookDTO findById(Long id) {
		logger.info("Finding book with id: {}", id);

		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		BookDTO bookDTO = CustomModelMapper.parseObject(entity, BookDTO.class);
		bookDTO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());

		return bookDTO;
	}

	@Override
	public BookDTO create(BookDTO bookDTO) {
		logger.info("Creating book: {}", bookDTO);

		if (bookDTO == null)
			throw new RequiredObjectIsNullException();

		Book book = CustomModelMapper.parseObject(bookDTO, Book.class);
		Book savedBook = repository.save(book);

		BookDTO createdBookDTO = CustomModelMapper.parseObject(savedBook, BookDTO.class);
		createdBookDTO.add(linkTo(methodOn(BookController.class).findById(createdBookDTO.getKey())).withSelfRel());

		return createdBookDTO;
	}

	@Override
	public BookDTO update(BookDTO bookDTO) {
		logger.info("Updating book with id: {}", bookDTO.getKey());

		Book existingBook = repository.findById(bookDTO.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		existingBook.setAuthor(bookDTO.getAuthor());
		existingBook.setLaunchDate(bookDTO.getLaunchDate());
		existingBook.setPrice(bookDTO.getPrice());
		existingBook.setTitle(bookDTO.getTitle());

		Book updatedBook = repository.save(existingBook);

		BookDTO updatedBookDTO = CustomModelMapper.parseObject(updatedBook, BookDTO.class);
		updatedBookDTO.add(linkTo(methodOn(BookController.class).findById(updatedBookDTO.getKey())).withSelfRel());

		return updatedBookDTO;
	}

	@Override
	public void delete(Long id) {
		logger.info("Deleting book with id: {}", id);

		Book book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(book);
	}
}
