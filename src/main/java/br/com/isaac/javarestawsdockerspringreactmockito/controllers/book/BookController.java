package br.com.isaac.javarestawsdockerspringreactmockito.controllers.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.services.book.BookService;

@RestController
@RequestMapping("api/book/v1")
public class BookController implements IBookController {

	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<BookDTO> findById(Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@Override
	public ResponseEntity<List<BookDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	public ResponseEntity<BookDTO> create(BookDTO book) {
		return ResponseEntity.ok(service.create(book));
	}

	@Override
	public ResponseEntity<BookDTO> update(BookDTO book) {
		return ResponseEntity.ok(service.update(book));
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
