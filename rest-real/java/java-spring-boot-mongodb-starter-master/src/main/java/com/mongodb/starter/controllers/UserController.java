/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Book;
import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.UserRepository;
import static java.util.Arrays.asList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * This is the class that will act as the controller for Book.java, controlling all the methods available
 */
@RestController
@RequestMapping("/api")
public class UserController {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;
    
    /**
     *
     * This is the default constructor, it initializes the userRepository
     */
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     *
     * A method that creates a new user and saves it using POST
     * 
     */
    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    /**
     *
     * A method that creates new users and saves them using POST
     */
    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> postUsers(@RequestBody List<User> users) {
        return userRepository.saveAll(users);
    }
    
    /**
     *
     * A method to get all the users stored
     */
    @GetMapping("users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    /**
     *
     * A method to get a single user using the id as the variable
     * 
     */
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userRepository.findOne(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }
    
    /**
     *
     * A method to get a single user using the num as the variable
     * 
     */
    @GetMapping("user/num/{num}")
    public ResponseEntity<User> getUserByNum(@PathVariable int num) {
        User user = userRepository.findOneNum(num);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }
    
    /**
     *
     * A method to get a single user using the name as the variable
     * 
     */
    @GetMapping("user/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        User user = userRepository.findOneUser(name);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }
    
    /**
     *
     * A method to get the amount of users stored
     */
    @GetMapping("users/count")
    public Long getCount() {
        return userRepository.count();
    }
    
    /**
     *
     * A method to delete a single user using the num as a variable
     * 
     */
    @DeleteMapping("user/delete/{num}")
    public Long deleteUserByNum(@PathVariable int num) {
        return userRepository.deleteOneUser(num);
    }
    
    /**
     *
     * A method to update an existing user
     * 
     */
    @PutMapping("user")
    public User putUser(@RequestBody User user) {
        return userRepository.update(user);
    }
    
    /**
     *
     *A method to hanlde all the exceptions
     *
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
