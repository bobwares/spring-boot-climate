package com.bobwares.climate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LocaleEnum {
    CA("CA"),
    US("US"),
    BR("BR");

    private final String locale;

    LocaleEnum(String locale) {
        this.locale = locale;
    }

    @JsonCreator
    public static LocaleEnum create(String value) {
        if(value == null) {
            return null;
        }
        for(LocaleEnum v : values()) {
            if(value.equals(v.toString())) {
                return v;
            }
        }
        return null;
    }
}
