/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Book;
import com.mongodb.starter.repositories.BookRepository;
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
public class BookController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    /**
     *
     * This is the default constructor, it initializes the bookRepository
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     *
     * A method that creates a new book and saves it using POST
     * 
     */
    @PostMapping("book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /**
     *
     * A method that creates new books and saves them using POST
     */
    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> postBooks(@RequestBody List<Book> books) {
        return bookRepository.saveAll(books);
    }

    /**
     *
     * A method to get all the books stored
     */
    @GetMapping("books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    /**
     *
     * A method to get a single book using the id as the variable
     * 
     */
    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        Book book = bookRepository.findOne(id);
        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(book);
    }
    
    /**
     *
     * A method to get a single book using the num as the variable
     * 
     */
    @GetMapping("book/num/{num}")
    public ResponseEntity<Book> getBookByNum(@PathVariable int num) {
        Book book = bookRepository.findOneNum(num);
        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(book);
    }
    
    /**
     *
     * A method to get a single book using the num as the variable
     * 
     */
    @GetMapping("book/countries")
    public List<String> getCountries() {
        return bookRepository.findAllCountries();
    }

    /**
     *
     * A method to get books using ids as the variable
     * 
     */
    @GetMapping("books/{ids}")
    public List<Book> getBooks(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return bookRepository.findAll(listIds);
    }

    /**
     *
     * A method to get the amount of books stored
     */
    @GetMapping("books/count")
    public Long getCount() {
        return bookRepository.count();
    }

    /**
     *
     *A method to delete a single book using the id as a variable
     * 
     */
    @DeleteMapping("book/{id}")
    public Long deleteBook(@PathVariable String id) {
        return bookRepository.delete(id);
    }
    
    /**
     *
     * A method to delete a single book using the num as a variable
     * 
     */
    @DeleteMapping("book/delete/{num}")
    public Long deleteBookByNum(@PathVariable int num) {
        return bookRepository.deleteOneNum(num);
    }

    /**
     *
     * A method to delete various books using ids as the variable at once
     * 
     */
    @DeleteMapping("books/{ids}")
    public Long deleteBooks(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return bookRepository.delete(listIds);
    } 

    /**
     *
     * A method to delete all the books (currently disabled)
     */
    @DeleteMapping("books")
    public Long deleteBooks() {
        return null;// bookRepository.deleteAll();
    }

    /**
     *
     * A method to update an existing book
     * 
     */
    @PutMapping("book")
    public Book putBook(@RequestBody Book book) {
        return bookRepository.update(book);
    }

    /**
     *
     * A method to update various books at once
     *
     */
    @PutMapping("books")
    public Long putBook(@RequestBody List<Book> books) {
        return bookRepository.update(books);
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