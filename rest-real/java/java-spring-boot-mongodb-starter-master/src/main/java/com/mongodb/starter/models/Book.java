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
 * @author unzalu.jon
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private int num;
    private String author;
    private String country;
    private String imageLink;
    private String language;
    private String link;
    private int pages;
    private String title;
    private int year;

    public ObjectId getId() {
        return id;
    }

    public Book setId(ObjectId id) {
        this.id = id;
        return this;
    }
    
    public int getNum() {
        return num;
    }

    public Book setNum(int num) {
        this.num = num;
        return this;
    }
    
    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Book setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Book setImageLink(String imageLink) {
        this.imageLink = imageLink;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Book setLink(String link) {
        this.link = link;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Book setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + "num=" + num + "author=" + author + ", country=" + country + ", imagelink=" + imageLink + ", language=" + language + ", link=" + link + ", pages=" + pages + ", title=" + title + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return num == book.num && pages == book.pages && year == book.year && Objects.equals(author, book.author) && Objects.equals(country,book.country) && 
                Objects.equals(imageLink,book.imageLink) && Objects.equals(language,book.language) && 
                Objects.equals(link, book.link) && Objects.equals(title, book.title);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, num, author, country, imageLink, language, link, pages, title, year);
    }
    
}
