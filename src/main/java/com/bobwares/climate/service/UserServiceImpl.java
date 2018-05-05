package com.bobwares.climate.service;

import com.bobwares.climate.domain.UserPost;
import com.bobwares.climate.entity.User;
import com.bobwares.climate.repository.UserRepository;
import com.bobwares.climate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }


    @Override

    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public User post(@Valid UserPost userPost)  {
        User user = User.builder()
                .name(userPost.getName())
                .birthDate(userPost.getBirthDate())
                .email(userPost.getEmail())
                .locale(userPost.getLocale())
                .phoneNumber(userPost.getPhoneNumber())
                .build();
        return userRepository.save(user);
    }
}
