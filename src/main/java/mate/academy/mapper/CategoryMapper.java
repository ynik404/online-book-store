package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dto.category.CategoryDto;
import mate.academy.dto.category.CreateCategoryRequestDto;
import mate.academy.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto requestDto);

    void updateCategoryFromDto(CreateCategoryRequestDto requestDto,
                               @MappingTarget Category category);
}
