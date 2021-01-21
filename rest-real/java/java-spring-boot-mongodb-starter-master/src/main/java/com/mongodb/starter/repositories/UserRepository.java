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

    /**
     *
     * @param user
     * @return
     */
    User save(User user);
    
    /**
     *
     * @param users
     * @return
     */
    List<User> saveAll(List<User> users);

    /**
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<User> findAll(List<User> ids);

    /**
     *
     * @param id
     * @return
     */
    User findOne(String id);
    
    /**
     *
     * @param num
     * @return
     */
    User findOneNum(int num);

    /**
     *
     * @return
     */
    long count();

    /**
     *
     * @param id
     * @return
     */
    long delete(String id);
    
    /**
     *
     * @param num
     * @return
     */
    long deleteOneUser(int num);

    /**
     *
     * @return
     */
    long deleteAll();

    /**
     *
     * @param book
     * @return
     */
    Book update(Book book);

}
