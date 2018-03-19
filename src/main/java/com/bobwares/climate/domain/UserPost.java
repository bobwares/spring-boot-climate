package com.bobwares.climate.domain;


import com.bobwares.climate.validation.emaildomain.EmailDomain;
import com.bobwares.climate.validation.locales.Locales;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPost {

    private String name;

    @NotNull
    @EmailDomain("climate.com")
    private String email;

    private String phoneNumber;

    @Locales
    private LocaleEnum locale;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    Date birthDate;

//    public Date getBirthDate() {
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        try {
//            return df.parse(getBirthDateAsString());
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
