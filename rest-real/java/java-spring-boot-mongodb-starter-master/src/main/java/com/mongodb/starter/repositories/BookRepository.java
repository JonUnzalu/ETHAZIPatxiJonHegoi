package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Book;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unzalu.jon
 */
@Repository
public interface BookRepository {

    /**
     *
     * @param book
     * @return
     */
    Book save(Book book);
    
    /**
     *
     * @param books
     * @return
     */
    List<Book> saveAll(List<Book> books);

    /**
     *
     * @return
     */
    List<Book> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<Book> findAll(List<String> ids);

    /**
     *
     * @param id
     * @return
     */
    Book findOne(String id);
    
    /**
     *
     * @param num
     * @return
     */
    Book findOneNum(int num);

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
    long deleteOneNum(int num);

    /**
     *
     * @param _ids
     * @return
     */
    long delete(List<String> _ids);

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

    /**
     *
     * @param books
     * @return
     */
    long update(List<Book> books);

    /**
     *
     * @return
     */
    double getAveragePages();
    
}
