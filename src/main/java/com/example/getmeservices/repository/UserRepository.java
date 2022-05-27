package com.example.getmeservices.repository;


import com.example.getmeservices.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByName(String name);

    List<User> getById(String PhotoUrl);
}