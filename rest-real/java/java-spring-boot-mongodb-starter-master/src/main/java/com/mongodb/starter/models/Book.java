/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * This is the model for Book
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private int num;
    private String author;
    private String country;
    private List<String> genres;
    private String imageLink;
    private String language;
    private String link;
    private int pages;
    private String title;
    private int year;

    /**
     *
     * This is the getter of id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * This is the setter of id
     *
     */
    public Book setId(ObjectId id) {
        this.id = id;
        return this;
    }
    
    /**
     *
     * This is the getter of num
     */
    public int getNum() {
        return num;
    }

    /**
     *
     * This is the setter of num
     *
     */
    public Book setNum(int num) {
        this.num = num;
        return this;
    }
    
    /**
     *
     * This is the getter of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * This is the setter of author
     *
     */
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     *
     * This is the getter of country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     *This is the setter of country
     *
     */
    public Book setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     *
     *This is the getter of genres
     *
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     *
     *This is the setter of genres
     *
     */
    public Book setGenres(List<String> genres) {
        this.genres = genres;
        return this;
    }
    
    /**
     *
     * This is the getter of imageLink
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     *
     * This is the setter of imageLink
     *
     */
    public Book setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    /**
     *
     * This is the getter of language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * This is the getter of language
     *
     */
    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     *
     * This is the getter of link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * This is the setter of link
     *
     */
    public Book setLink(String link) {
        this.link = link;
        return this;
    }

    /**
     *
     * This is the getter of pages
     */
    public int getPages() {
        return pages;
    }

    /**
     *
     * This is the setter of pages
     *
     */
    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    /**
     *
     * This is the getter of title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * This is the setter of title
     *
     */
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     *
     * This is the getter of year
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * This is the setter of year
     *
     */
    public Book setYear(int year) {
        this.year = year;
        return this;
    }

    /**
     *
     * This is the toString method of this model
     */
    @Override
    public String toString() {
        return "Book{" + "id=" + id + "num=" + num + "author=" + author + ", country=" + country + ", genres=" + genres + ", imagelink=" + imageLink + ", language=" + language + ", link=" + link + ", pages=" + pages + ", title=" + title + ", year=" + year + '}';
    }

    /**
     *
     * This is the equals
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return num == book.num && pages == book.pages && year == book.year && Objects.equals(author, book.author) && Objects.equals(country,book.country) && 
                Objects.equals(genres, book.genres) && Objects.equals(imageLink,book.imageLink) && Objects.equals(language,book.language) && 
                Objects.equals(link, book.link) && Objects.equals(title, book.title);
    }
    
    /**
     *
     * This is the hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, num, author, country, genres, imageLink, language, link, pages, title, year);
    }
    
}
