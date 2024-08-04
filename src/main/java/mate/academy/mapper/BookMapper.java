package mate.academy.mapper;

import java.util.stream.Collectors;
import mate.academy.config.MapperConfig;
import mate.academy.dto.book.BookDto;
import mate.academy.dto.book.BookDtoWithoutCategoryIds;
import mate.academy.dto.book.BookRequestDto;
import mate.academy.model.Book;
import mate.academy.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toEntity(BookRequestDto requestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    void updateBookFromDto(BookRequestDto requestDto, @MappingTarget Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        if (book.getCategories() != null) {
            bookDto.setCategoryIds(book.getCategories().stream()
                    .map(Category::getId)
                    .collect(Collectors.toSet()));
        }
    }

    @AfterMapping
    default void setCategories(@MappingTarget Book book, BookRequestDto requestDto) {
        if (requestDto.getCategoryIds() != null) {
            book.setCategories(requestDto.getCategoryIds().stream()
                    .map(categoryId -> {
                        Category category = new Category();
                        category.setId(categoryId);
                        return category;
                    }).collect(Collectors.toSet()));
        }
    }
}
