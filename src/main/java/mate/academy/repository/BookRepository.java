package mate.academy.repository;

import java.util.List;
import mate.academy.model.Book;

public interface BookRepository {
    Book createBook(Book book);

    Book getBookById(Long id);

    List<Book> findAll();
}
