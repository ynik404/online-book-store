package mate.academy.service;

import java.util.List;
import mate.academy.dto.BookDto;
import mate.academy.dto.BookSearchParameters;
import mate.academy.dto.CreateBookRequestDto;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);

    BookDto getBookById(long id);

    List<BookDto> findAll();

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters params);
}
