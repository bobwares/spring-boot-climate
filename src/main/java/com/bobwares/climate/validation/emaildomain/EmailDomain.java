package com.bobwares.climate.validation.emaildomain;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy =  EmailDomainValidator.class)
@Email
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface EmailDomain {
    String value();

    String message() default "{email.domain}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
