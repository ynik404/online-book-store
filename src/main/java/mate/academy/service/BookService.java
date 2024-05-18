package mate.academy.service;

import java.util.List;

import mate.academy.dto.BookDto;
import mate.academy.dto.CreateBookRequestDto;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);

    BookDto getBookById(long id);

    List<BookDto> findAll();
}
