package mate.academy.service;

import java.util.List;
import mate.academy.dto.book.BookDto;
import mate.academy.dto.book.BookDtoWithoutCategoryIds;
import mate.academy.dto.book.BookSearchParameters;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(long id);

    List<BookDto> findAll(Pageable pageable);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters params, Pageable pageable);

    BookDto updateBookById(Long id, BookDto bookDto);

    List<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id);
}
