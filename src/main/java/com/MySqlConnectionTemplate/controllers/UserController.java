package com.MySqlConnectionTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MySqlConnectionTemplate.model.domain.jpaEntities.UserEntity;
import com.MySqlConnectionTemplate.repository.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(firstName);
        user.setEmail(email);
        userRepository.save(user);
        return "User Created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable < UserEntity > getAllUsers() {
        return userRepository.findAll();
    }

}