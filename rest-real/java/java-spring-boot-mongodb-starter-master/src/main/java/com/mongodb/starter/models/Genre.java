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
 * @author unzalu.jon
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Genre {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private int genreNum;
    private String name;

    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id
     * @return
     */
    public Genre setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public int getGenreNum() {
        return genreNum;
    }

    public Genre setGenreNum(int genreNum) {
        this.genreNum = genreNum;
        return this;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * @return
     */
    public Genre setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Genre{" + "id=" + id + ", genreNum=" + genreNum + ", name=" + name + '}';
    }
    
    /**
     *
     * @param o
     * @return
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
    
    @Override
    public int hashCode() {
        return Objects.hash(id, genreNum, name);
    }
    
    

}
