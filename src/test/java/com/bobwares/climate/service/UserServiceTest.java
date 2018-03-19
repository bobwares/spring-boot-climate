package com.bobwares.climate.service;

import com.bobwares.climate.domain.LocaleEnum;
import com.bobwares.climate.entity.User;
import com.bobwares.climate.repository.UserRepository;
import com.bobwares.climate.service.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
class UserServiceTest {

    private  static final Long TEST_ID = 1L;

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        User user = User
                    .builder()
                    .name("Chad Smith")
                    .phoneNumber("314-333-3333")
                    .locale(LocaleEnum.CA)
                    .email("chad.smith@climate.com")
                    .build();

        Optional<User> optional = Optional.of(user);
        MockitoAnnotations.initMocks(this);
        when(userRepository.findById(TEST_ID)).thenReturn(optional);
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

    }

    @Test
    void getAll() throws Exception {

    }

    @Test
    void get() throws Exception {
        Optional<User> optional = userService.get(TEST_ID);
        assertNotNull(optional.orElse(null));
    }

    @Test
    void post() throws Exception {

    }

}