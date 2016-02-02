package com.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.MongoClient;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);
    public User findByUserid(ObjectId userid);

}
