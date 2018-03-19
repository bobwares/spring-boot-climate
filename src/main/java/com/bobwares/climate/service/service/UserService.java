package com.bobwares.climate.service.service;

import com.bobwares.climate.domain.UserPost;
import com.bobwares.climate.entity.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> getAll();

    Optional<User> get(long id);

    User post(UserPost userPost);

}
