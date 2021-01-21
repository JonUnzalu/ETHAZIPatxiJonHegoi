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
 * This is the model for user
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
    public User setId(ObjectId id) {
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
    public User setNum(int num) {
        this.num = num;
        return this;
    }
    
    /**
     *
     * This is the getter of username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * This is the setter of username
     *
     */
    public User setUsername(String username) {
        this.username = username;
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
    public User setName(String name) {
        this.name = name;
        return this;
    }
        
    /**
     *
     * This is the getter of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * This is the setter of surname
     *
     */
    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    
    /**
     *
     * This is the getter of email
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * This is the setter of email
     *
     */
    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }
    
    /**
     *
     * This is the getter of password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * This is the setter of password
     * 
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
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
        User user = (User) o;
        return num == user.num && Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && 
                Objects.equals(mail, user.mail) && Objects.equals(password, user.password);
    }
    
    /**
     *
     * This is the hashcode of this model
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, num, username, name, surname, mail, password);
    }
    
}
