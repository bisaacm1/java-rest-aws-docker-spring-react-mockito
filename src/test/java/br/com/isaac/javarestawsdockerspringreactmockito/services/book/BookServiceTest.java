package br.com.isaac.javarestawsdockerspringreactmockito.services.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.mocks.MockData;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Book;
import br.com.isaac.javarestawsdockerspringreactmockito.repositories.BookRepository;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions.RequiredObjectIsNullException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

  @InjectMocks
  private BookService service;

  @Mock
  private BookRepository repository;

  private MockData mockData;

  @BeforeEach
  void setUp() {
    mockData = new MockData();
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindById() {
    Book book = mockData.createBookEntity(1);
    book.setId(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(book));

    BookDTO result = service.findById(1L);

    assertNotNull(result, "Result should not be null");
    assertNotNull(result.getKey(), "Key should not be null");
    assertNotNull(result.getLinks(), "Links should not be null");
    assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"), "Links should contain self link");
    assertEquals("Author Test 1", result.getAuthor(), "Author should match");
    assertEquals("Title Test 1", result.getTitle(), "Title should match");
  }

  @Test
  void testFindAll() {
    List<Book> books = mockData.createBookEntityList(14);

    when(repository.findAll()).thenReturn(books);

    List<BookDTO> result = service.findAll();

    assertNotNull(result, "Result list should not be null");
    assertEquals(14, result.size(), "Result list size should match");

    BookDTO firstBook = result.get(0);

    assertNotNull(firstBook.getKey(), "Key should not be null");
    assertNotNull(firstBook.getLinks(), "Links should not be null");
    assertEquals("Author Test 0", firstBook.getAuthor(), "Author should match");
    assertEquals("Title Test 0", firstBook.getTitle(), "Title should match");
  }

  @Test
  void testCreate() {
    Book book = mockData.createBookEntity(0);
    book.setId(1L);

    BookDTO bookDTO = mockData.createBookDTO(1);
    bookDTO.setKey(1L);

    when(repository.save(any(Book.class))).thenReturn(book);

    BookDTO result = service.create(bookDTO);

    assertNotNull(result, "Result should not be null");
    assertNotNull(result.getKey(), "Key should not be null");
    assertNotNull(result.getLinks(), "Links should not be null");
    assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"), "Links should contain self link");
    assertEquals("Author Test 0", result.getAuthor(), "Author should match");
    assertEquals("Title Test 0", result.getTitle(), "Title should match");
  }

  @Test
  void testCreateWithNullBook() {
    Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> service.create(null));

    String expectedMessage = "It is not allowed to persist a null object!";
    assertEquals(expectedMessage, exception.getMessage(), "Exception message should match");
  }

  @Test
  void testUpdate() {
    Book book = mockData.createBookEntity(1);
    book.setId(1L);

    BookDTO bookDTO = mockData.createBookDTO(1);
    bookDTO.setKey(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(book));
    when(repository.save(any(Book.class))).thenReturn(book);

    BookDTO result = service.update(bookDTO);

    assertNotNull(result, "Result should not be null");
    assertNotNull(result.getKey(), "Key should not be null");
    assertNotNull(result.getLinks(), "Links should not be null");
    assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"), "Links should contain self link");
    assertEquals("Author Test 1", result.getAuthor(), "Author should match");
    assertEquals("Title Test 1", result.getTitle(), "Title should match");
  }

  @Test
  void testDelete() {
    Book book = mockData.createBookEntity(1);
    book.setId(1L);

    when(repository.findById(1L)).thenReturn(Optional.of(book));

    service.delete(1L);

    verify(repository, times(1)).delete(book);
  }
}
