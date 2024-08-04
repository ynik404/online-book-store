package mate.academy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dto.book.BookDto;
import mate.academy.dto.book.BookRequestDto;
import mate.academy.dto.book.BookSearchParameters;
import mate.academy.service.BookService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Book management",
        description = "Endpoints for managing books")
public class BookController {
    private final BookService bookService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    @Operation(summary = "Get all books",
            description = "Retrieves all available books with pagination and sorting support")
    public List<BookDto> getAll(@ParameterObject @PageableDefault Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    @Operation(summary = "Get book by id",
            description = "Retrieves available book by id")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new book",
            description = "Create a new book")
    public BookDto createBook(@RequestBody @Valid BookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "Change book's description",
            description = "Change book's description")
    public BookDto updateBookById(@PathVariable Long id,
                                  @RequestBody @Valid BookRequestDto requestDto) {
        return bookService.updateBookById(id, requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book",
            description = "Deletes book by id")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/search")
    @Operation(summary = "Get all books by parameters",
            description = "Retrieves a list of all available books by parameters")
    public List<BookDto> search(BookSearchParameters searchParametersDto,
                                @ParameterObject @PageableDefault Pageable pageable) {
        return bookService.search(searchParametersDto, pageable);
    }
}
