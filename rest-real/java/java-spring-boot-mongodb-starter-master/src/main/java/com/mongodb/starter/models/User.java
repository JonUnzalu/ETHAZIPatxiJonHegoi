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
public class User {
    
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private int num;
    private String username;
    private String name;
    private String surname;
    private String mail;
    private String password;
    
    /**
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id
     * @return
     */
    public User setId(ObjectId id) {
        this.id = id;
        return this;
    }
    
    /**
     *
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     *
     * @param num
     * @return
     */
    public User setNum(int num) {
        this.num = num;
        return this;
    }
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * @return
     */
    public User setUsername(String username) {
        this.username = username;
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
    public User setName(String name) {
        this.name = name;
        return this;
    }
        
    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     * @return
     */
    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    
    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     * @return
     */
    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }
    
    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * @return
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
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
        User user = (User) o;
        return num == user.num && Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && 
                Objects.equals(mail, user.mail) && Objects.equals(password, user.password);
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, num, username, name, surname, mail, password);
    }
    
}
