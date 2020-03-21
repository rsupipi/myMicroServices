package com.pipi.controller;

import com.pipi.bean.UserJPA;
import com.pipi.repository.UserRepository;

import com.pipi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAController {

    @Autowired
    private UserRepository userRepository;

    // get all ==================================================
    @GetMapping("jpa/users")
    public List<UserJPA> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // get by ID ==================================================
    @GetMapping("jpa/users/{id}")
    public Optional<UserJPA> retrieveUser2(@PathVariable int id) {
        Optional<UserJPA> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // save  ==================================================
    @PostMapping("jpa/user")
    public UserJPA createUser1(@RequestBody UserJPA user) {
        UserJPA userJPA = userRepository.save(user);
        return user;
    }

    // delete ==================================================
    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
