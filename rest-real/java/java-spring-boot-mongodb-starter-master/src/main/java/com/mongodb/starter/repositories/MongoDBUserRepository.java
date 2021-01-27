/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.starter.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import static com.mongodb.client.model.ReturnDocument.AFTER;
import com.mongodb.starter.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * MongoDB repositories
 */
@Repository
public class MongoDBUserRepository implements UserRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    
    
    @Autowired
    private MongoClient client;
    private MongoCollection<User> userCollection;
    
    @PostConstruct
    void init() {
        userCollection = client.getDatabase("test").getCollection("users", User.class);
    }
    
    @Override
    public User save(User user) {
        user.setId(new ObjectId());
        userCollection.insertOne(user);
        return user;
    }

    @Override
    public List<User> saveAll(List<User> users) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                users.forEach(p -> p.setId(new ObjectId()));
                userCollection.insertMany(clientSession, users);
                return users;
            }, txnOptions);
        }
    }

    @Override
    public List<User> findAll() {
        return userCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<User> findAll(List<User> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findOneNum(int number) {
        return userCollection.find(in("num", number)).first();
    }

    @Override
    public User findOneUser(String name) {
        return userCollection.find(eq("username", name)).first();
    }
    
    @Override
    public User findOneUserPass(String password) {
        return userCollection.find(eq("password", password)).first();
    }
    
    @Override
    public long count() {
        return userCollection.countDocuments();
    }

    @Override
    public long delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long deleteOneUser(int num) {
        return userCollection.deleteOne(eq("num", num)).getDeletedCount();  
    }

    @Override
    public long deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User user) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return userCollection.findOneAndReplace(eq("num", user.getNum()) , user, options);
    }
    
    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }

    
}
