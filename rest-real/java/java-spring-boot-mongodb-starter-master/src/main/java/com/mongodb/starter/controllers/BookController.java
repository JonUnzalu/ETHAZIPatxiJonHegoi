/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Book;
import com.mongodb.starter.models.Person;
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
 * @author unzalu.jon
 */
@RestController
@RequestMapping("/api")
public class BookController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> postBooks(@RequestBody List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @GetMapping("books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        Book book = bookRepository.findOne(id);
        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(book);
    }
    
    @GetMapping("book/num/{num}")
    public ResponseEntity<Book> getBookByNum(@PathVariable int num) {
        Book book = bookRepository.findOneNum(num);
        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(book);
    }

    @GetMapping("books/{ids}")
    public List<Book> getBooks(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return bookRepository.findAll(listIds);
    }

    @GetMapping("books/count")
    public Long getCount() {
        return bookRepository.count();
    }

    @DeleteMapping("book/{id}")
    public Long deleteBook(@PathVariable String id) {
        return bookRepository.delete(id);
    }
    
    @DeleteMapping("book/delete/{num}")
    public Long deleteBookByNum(@PathVariable int num) {
        return bookRepository.deleteOneNum(num);
    }

    @DeleteMapping("books/{ids}")
    public Long deleteBooks(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return bookRepository.delete(listIds);
    } 

    @DeleteMapping("books")
    public Long deleteBooks() {
        return bookRepository.deleteAll();
    }

    @PutMapping("book")
    public Book putBook(@RequestBody Book book) {
        return bookRepository.update(book);
    }

    @PutMapping("books")
    public Long putBook(@RequestBody List<Book> books) {
        return bookRepository.update(books);
    }

    @GetMapping("books/averagePages")
    public Double averagePages() {
        return bookRepository.getAveragePages();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}