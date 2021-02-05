/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.repositories;

import com.mongodb.starter.models.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * User repository
 */
@Repository
public interface UserRepository {

    /**
     *
     * Save a single user
     *
     */
    User save(User user);
    
    /**
     *
     * Save more than one user
     *
     */
    List<User> saveAll(List<User> users);

    /**
     *
     * Save all users
     */
    List<User> findAll();

    /**
     *
     * Find all users
     *
     */
    List<User> findAll(List<User> users);

    
    /**
     *
     * Find one user by num
     *
     */
    User findOneNum(int num);

    /**
     *
     * Find one user by name
     *
     */
    User findOneUser(String name);

    
    /**
     *
     * Find one password
     *
     */
    User findOneUserPass(String password);
    
    /**
     *
     * Count the number of users
     */
    long count();
    
    /**
     *
     * Delete one user by num
     *
     */
    long deleteOneUser(int num);

    /**
     *
     * Delete all users
     */
    long deleteAll();

    /**
     *
     * Update user
     *
     */
    User update(User user);

}
