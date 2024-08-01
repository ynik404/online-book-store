package mate.academy.mapper;

import java.util.stream.Collectors;
import mate.academy.config.MapperConfig;
import mate.academy.dto.book.BookDto;
import mate.academy.dto.book.BookDtoWithoutCategoryIds;
import mate.academy.model.Book;
import mate.academy.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    void updateBookFromDto(BookDto bookDto, @MappingTarget Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        if (book.getCategories() != null) {
            bookDto.setCategoryIds(book.getCategories().stream()
                    .map(Category::getId)
                    .collect(Collectors.toSet()));
        }
    }

    @AfterMapping
    default void setCategories(@MappingTarget Book book, BookDto bookDto) {
        if (bookDto.getCategoryIds() != null) {
            book.setCategories(bookDto.getCategoryIds().stream()
                    .map(categoryId -> {
                        Category category = new Category();
                        category.setId(categoryId);
                        return category;
                    }).collect(Collectors.toSet()));
        }
    }
}
