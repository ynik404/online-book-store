package mate.academy.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Object firstObj = new BeanWrapperImpl(value)
                    .getPropertyValue(this.firstFieldName);
            final Object secondObj = new BeanWrapperImpl(value)
                    .getPropertyValue(this.secondFieldName);
            boolean isValid = Objects.equals(firstObj, secondObj);
            if (!isValid) {
                context.buildConstraintViolationWithTemplate(message)
                        .addPropertyNode(firstFieldName)
                        .addConstraintViolation()
                        .disableDefaultConstraintViolation();
            }
            return isValid;
        } catch (final Exception exception) {
            throw new RuntimeException("Error during field matching validation", exception);
        }
    }
}
