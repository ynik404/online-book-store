package mate.academy.mapper.impl;

import javax.annotation.processing.Generated;
import mate.academy.dto.BookDto;
import mate.academy.dto.CreateBookRequestDto;
import mate.academy.mapper.BookMapper;
import mate.academy.model.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-23T17:05:31+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        if ( book.getId() != null ) {
            bookDto.setId( book.getId() );
        }
        if ( book.getTitle() != null ) {
            bookDto.setTitle( book.getTitle() );
        }
        if ( book.getAuthor() != null ) {
            bookDto.setAuthor( book.getAuthor() );
        }
        if ( book.getIsbn() != null ) {
            bookDto.setIsbn( book.getIsbn() );
        }
        if ( book.getPrice() != null ) {
            bookDto.setPrice( book.getPrice() );
        }
        if ( book.getDescription() != null ) {
            bookDto.setDescription( book.getDescription() );
        }
        if ( book.getCoverImage() != null ) {
            bookDto.setCoverImage( book.getCoverImage() );
        }

        return bookDto;
    }

    @Override
    public Book toModel(CreateBookRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Book book = new Book();

        if ( requestDto.getTitle() != null ) {
            book.setTitle( requestDto.getTitle() );
        }
        if ( requestDto.getAuthor() != null ) {
            book.setAuthor( requestDto.getAuthor() );
        }
        if ( requestDto.getIsbn() != null ) {
            book.setIsbn( requestDto.getIsbn() );
        }
        if ( requestDto.getPrice() != null ) {
            book.setPrice( requestDto.getPrice() );
        }
        if ( requestDto.getDescription() != null ) {
            book.setDescription( requestDto.getDescription() );
        }
        if ( requestDto.getCoverImage() != null ) {
            book.setCoverImage( requestDto.getCoverImage() );
        }

        return book;
    }
}
