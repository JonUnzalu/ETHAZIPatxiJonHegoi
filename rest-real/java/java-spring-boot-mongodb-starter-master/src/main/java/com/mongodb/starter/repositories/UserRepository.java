/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Book;
import com.mongodb.starter.models.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unzalu.jon
 */
@Repository
public interface UserRepository {
    User save(User user);
    
    List<User> saveAll(List<User> users);

    List<User> findAll();

    List<User> findAll(List<User> ids);

    User findOne(String id);
    
    /**
     *
     * @param num
     * @return
     */
    User findOneNum(int num);

    long count();

    long delete(String id);
    
    long deleteOneUser(int num);

    long deleteAll();

    Book update(Book book);

}
