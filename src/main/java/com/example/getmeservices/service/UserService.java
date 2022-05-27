package com.example.getmeservices.service;

import com.example.getmeservices.model.User;
import com.example.getmeservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User updateUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {

        userRepository.deleteById(userId);
    }

    public User getById(String PhotoUrl, String photoUrl) {

        return (User) userRepository.getById(PhotoUrl);
    }


    public List<User> getByName(String name) {
       return userRepository.findAllByName(name);
    }



}
