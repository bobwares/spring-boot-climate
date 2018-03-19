package com.bobwares.climate.domain;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserPostTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
     void testField() throws ParseException {
        String target = "11/22/1930";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate =  df.parse(target);

        UserPost userPost = UserPost
                .builder()
                .locale(LocaleEnum.BR)
                .birthDate(birthDate)
                .email("test@climate.com").build();

        Set<ConstraintViolation<UserPost>> violations =
                validator.validate(userPost);

        assertEquals(0, violations.size());
    }

    @Test
    void testFailureEmailField() throws ParseException {
        String target = "11/22/1930";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate =  df.parse(target);

        UserPost userPost = UserPost
                .builder()
                .birthDate(birthDate)
                .locale(LocaleEnum.BR)
                .email("test@bobwares.com").build();


        Set<ConstraintViolation<UserPost>> violations =
                validator.validate(userPost);

        assertEquals(1, violations.size());
    }

    @Test
    void testFailureLocaleField() throws ParseException {

        String target = "11/22/1931";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date birthDate =  df.parse(target);

        UserPost userPost = UserPost
                .builder()
                .birthDate(birthDate)
                .locale(null)
                .email("test@climate.com")
                .build();


        Set<ConstraintViolation<UserPost>> violations = validator.validate(userPost);

        assertEquals(2, violations.size());
    }
}