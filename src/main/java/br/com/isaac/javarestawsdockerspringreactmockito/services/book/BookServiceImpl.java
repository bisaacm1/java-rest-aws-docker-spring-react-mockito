package br.com.isaac.javarestawsdockerspringreactmockito.services.book;

import java.util.List;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;

public interface BookServiceImpl {
  List<BookDTO> findAll();

  BookDTO findById(Long id);

  BookDTO create(BookDTO book);

  BookDTO update(BookDTO book);

  void delete(Long id);
}
