package com.pipi.controller;

import com.pipi.bean.User;
import com.pipi.bean.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> retrive


}
