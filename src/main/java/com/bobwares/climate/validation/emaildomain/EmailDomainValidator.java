package com.bobwares.climate.validation.emaildomain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.StringUtils.isEmpty;

public class EmailDomainValidator implements ConstraintValidator<EmailDomain, String> {

    private EmailDomain annotation;

    @Override
    public void initialize(EmailDomain constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (isEmpty(value)) {
            return false;
        }
        String domain = value.split("@")[1];
        return (domain.equalsIgnoreCase(annotation.value()));
    }
}
