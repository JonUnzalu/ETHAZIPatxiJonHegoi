/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * This is the method of genre
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Genre {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private int genreNum;
    private String name;

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
    public Genre setId(ObjectId id) {
        this.id = id;
        return this;
    }

    /**
     *
     * This is the getter of genre
     */
    public int getGenreNum() {
        return genreNum;
    }

    /**
     *
     * This is the setter of genre
     *
     */
    public Genre setGenreNum(int genreNum) {
        this.genreNum = genreNum;
        return this;
    }

    /**
     *
     * This is the getter of name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * This is the setter of name
     *
     */
    public Genre setName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * This is the toString method of this model
     */
    @Override
    public String toString() {
        return "Genre{" + "id=" + id + ", genreNum=" + genreNum + ", name=" + name + '}';
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
        
        Genre genre = (Genre) o;
        return genreNum == genre.genreNum && Objects.equals(name, genre.name);
    }
    
    /**
     *
     * This is the hashCode of this model
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, genreNum, name);
    }
    
    

}
