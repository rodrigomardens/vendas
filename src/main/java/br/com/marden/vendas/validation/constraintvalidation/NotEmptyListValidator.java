package br.com.marden.vendas.validation.constraintvalidation;

import br.com.marden.vendas.validation.NotEmptyList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {
    @Override
    public void initialize(NotEmptyList constraintAnnotation) {

    }

    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}
