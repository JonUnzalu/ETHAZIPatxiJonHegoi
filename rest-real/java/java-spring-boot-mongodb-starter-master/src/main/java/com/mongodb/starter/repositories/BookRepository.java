package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Book;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * This is the book repository
 */
@Repository
public interface BookRepository {

    /**
     *
     * Save one book
     *
     */
    Book save(Book book);
    
    /**
     *
     * save all books
     *
     */
    List<Book> saveAll(List<Book> books);

    /**
     *
     * select all books
     */
    List<Book> findAll();
    
    /**
     *
     * get all countries
     */
    List<String> findAllCountries();

    /**
     *
     * The id of the book
     *
     */
    Book findOne(String id);
    
    /**
     *
     * The number of the book
     *
     */
    Book findOneNum(int num);

    /**
     *
     * Count how many books are 
     */
    long count();

    /**
     *
     * Delete books by the id of the book
     *
     */
    long delete(String id);
    
    /**
     *
     * Delete one book by the num of the book
     *
     */
    long deleteOneNum(int num);

    /**
     *
     * Delete all books
     */
    long deleteAll();

    /**
     *
     * Update one book
     *
     */
    Book update(Book book);
    
}
