package com.bobwares.climate.endpoint;

import com.bobwares.climate.domain.LocaleEnum;
import com.bobwares.climate.domain.UserPost;
import com.bobwares.climate.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void get() {
        User user  = this.restTemplate.getForObject("/user/1", User.class);
        assertEquals(user.getPhoneNumber(),"555-555-5555");
    }

    @Test
    void post() {
        UserPost userPost = UserPost
                .builder()
                .name("John Frusciante")
                .phoneNumber("314-333-3333")
                .locale(LocaleEnum.CA)
                .email("chad.smith@climate.com")
                .birthDate(new Date())
                .build();

        ResponseEntity<User> responseEntity = restTemplate.postForEntity("/user", userPost, User.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(responseEntity.getBody().getId());
    }

}