package com.dennis.mybackend.controller;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 

import com.dennis.mybackend.model.Userr;

import com.dennis.mybackend.repo.UserRepo;

 

@RestController

@RequestMapping("/api")

public class MyController {

 

    private final UserRepo userRepository;

   

    public MyController(UserRepo repo) {

               this.userRepository = repo;

    }

 

    @GetMapping("/users")

    public List<Userr> getUsers() {

        return (List<Userr>) userRepository.findAll();

    }

 

    @PostMapping("/users")

    void addUser(@RequestBody Userr userr) {

               userr.setId(null);                          // null sets to auto number?

        userRepository.save(userr);

    }

}