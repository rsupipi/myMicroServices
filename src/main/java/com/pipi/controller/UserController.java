package com.pipi.controller;

import com.pipi.bean.User;
import com.pipi.service.UserDaoService;
import com.pipi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    // get all ==================================================
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    // get by ID ==================================================
    @GetMapping("/users1/{id}")
    public User retrieveUser1(@PathVariable int id) {
        return userService.findOne(id);
    }

    @GetMapping("/users2/{id}")
    public User retrieveUser2(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // save  ==================================================
    @PostMapping("/users1")
    public User createUser1(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * returning status code and Location URI
     **/
    @PostMapping("/users2")
    public ResponseEntity<Object> createUser2(@RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // delete ==================================================
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);

        if (user == null){
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }
}
