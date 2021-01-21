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
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.WriteModel;
import com.mongodb.starter.dtos.AverageAgeDTO;
import com.mongodb.starter.models.Person;
import org.bson.BsonDocument;
import org.bson.BsonNull;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.ReturnDocument.AFTER;
import static java.util.Arrays.asList;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.starter.dtos.AveragePageBOOK;
import com.mongodb.starter.models.Book;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author unzalu.jon
 */
@Repository
public class MongoDBBookRespository implements BookRepository {
    
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Book> bookCollection;

    @PostConstruct
    void init() {
        bookCollection = client.getDatabase("test").getCollection("books", Book.class);
    }

    @Override
    public Book save(Book book) {
        book.setId(new ObjectId());
        bookCollection.insertOne(book);
        return book;    
    }

    @Override
    public List<Book> saveAll(List<Book> books) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                books.forEach(p -> p.setId(new ObjectId()));
                bookCollection.insertMany(clientSession, books);
                return books;
            }, txnOptions);
        }
    }

    @Override
    public List<Book> findAll() {
        return bookCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Book> findAll(List<String> ids) {
        return bookCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }
    
    @Override
    public Book findOneNum(int number) {
        return bookCollection.find(in("num", number)).first();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Book findOne(String id) {
        return bookCollection.find(eq("_id", new ObjectId(id))).first();
    }

    /**
     *
     * @return
     */
    @Override
    public long count() {
        return bookCollection.countDocuments();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public long delete(String id) {
        return bookCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> bookCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
                    txnOptions);
        }    
    }
    
    @Override
    public long deleteOneNum(int num) {
        return bookCollection.deleteOne(eq("num", num)).getDeletedCount();  
    }

    /**
     *
     * @return
     */
    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> bookCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }    }

    @Override
    public Book update(Book book) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return bookCollection.findOneAndReplace(eq("_id", book.getId()), book, options);    
    }

    /**
     *
     * @param books
     * @return
     */
    @Override
    public long update(List<Book> books) {
        List<WriteModel<Book>> writes = books.stream()
                                                 .map(p -> new ReplaceOneModel<>(eq("_id", p.getId()), p))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> bookCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }    }
    
    @Override
    public double getAveragePages() {
        List<Bson> pipeline = asList(group(new BsonNull(), avg("averagePages", "$pages")), project(excludeId()));
        return bookCollection.aggregate(pipeline, AveragePageBOOK.class).first().getAveragePages();
    }
    
    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }

}
