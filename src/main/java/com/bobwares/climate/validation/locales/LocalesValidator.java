package com.bobwares.climate.validation.locales;

import com.bobwares.climate.domain.LocaleEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocalesValidator implements ConstraintValidator<Locales,LocaleEnum> {

    private Locales annotation;

    @Override
    public void initialize(Locales constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(LocaleEnum value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
