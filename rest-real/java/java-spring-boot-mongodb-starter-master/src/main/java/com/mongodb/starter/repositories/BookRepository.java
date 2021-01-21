package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Book;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository {
    Book save(Book book);
    
    List<Book> saveAll(List<Book> books);

    List<Book> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<Book> findAll(List<String> ids);

    Book findOne(String id);
    
    Book findOneNum(int num);

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
    long deleteOneNum(int num);

    long delete(List<String> _ids);

    long deleteAll();

    Book update(Book book);

    long update(List<Book> books);

    double getAveragePages();
    
}
