package mate.academy.repository;

import lombok.RequiredArgsConstructor;
import mate.academy.dto.BookSearchParameters;
import mate.academy.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParametersDto) {
        Specification<Book> specification = Specification.where(null);
        if (searchParametersDto.title() != null && searchParametersDto.title().length > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider("title")
                            .getSpecification(searchParametersDto.title()));
        }
        if (searchParametersDto.author() != null && searchParametersDto.author().length > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider("author")
                            .getSpecification(searchParametersDto.author()));
        }
        if (searchParametersDto.isbn() != null && searchParametersDto.isbn().length > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider("isbn")
                            .getSpecification(searchParametersDto.isbn()));

        }
        return specification;
    }
}
