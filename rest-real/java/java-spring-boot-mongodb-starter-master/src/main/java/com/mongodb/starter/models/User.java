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
    
    public ObjectId getId() {
        return id;
    }

    public User setId(ObjectId id) {
        this.id = id;
        return this;
    }
    
    public int getNum() {
        return num;
    }

    public User setNum(int num) {
        this.num = num;
        return this;
    }
    
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
    
    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
        
    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    
    public String getMail() {
        return mail;
    }

    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }
    
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
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
    
    @Override
    public int hashCode() {
        return Objects.hash(id, num, username, name, surname, mail, password);
    }
    
}
