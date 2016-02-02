package com.example.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String>{
	public List<Route> findByUserid(ObjectId userid);
	public Route findByRouteid(ObjectId routeid);
}
