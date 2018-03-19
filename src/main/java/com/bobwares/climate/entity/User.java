package com.bobwares.climate.entity;

import com.bobwares.climate.domain.LocaleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "USER_SEQ")
    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LocaleEnum locale;

    Date birthDate;
}
