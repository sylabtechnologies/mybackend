package com.dennis.mybackend;

import java.util.stream.Stream;

 

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

 
import com.dennis.mybackend.model.Userr;

import com.dennis.mybackend.repo.UserRepo;

 

@SpringBootApplication

public class MybackendApplication {

 

              public static void main(String[] args) {

                             SpringApplication.run(MybackendApplication.class, args);

              }

 

    @Bean

    CommandLineRunner init(UserRepo userRepository) {

        return args -> {

            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {

                Userr userr = new Userr();

                userr.setName(name);

                userr.setEmail(name.toLowerCase() + "@domain.com");

                userRepository.save(userr);

            });

            userRepository.findAll().forEach(System.out::println);

        };

    }

}