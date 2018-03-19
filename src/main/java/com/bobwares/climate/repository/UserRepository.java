package com.bobwares.climate.repository;

import com.bobwares.climate.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}