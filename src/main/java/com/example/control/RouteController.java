package com.example.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Route;
import com.example.model.RouteRepository;
import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

@CrossOrigin(origins = "*")
@RestController
public class RouteController {
	
	@Autowired
	RouteRepository routeRepository;
	
    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public List<Route> listRoutes(@RequestBody String data){
    	JsonObject dataBody = (JsonObject) (new JsonParser()).parse(data);
    	ObjectId userid = new ObjectId();
		try {
			userid = new ObjectMapper().readValue(dataBody.get("userid").toString(), ObjectId.class);
			System.out.println(userid.toString());
			return routeRepository.findByUserid(userid);
		} catch (IOException e) {
			e.printStackTrace();
			return routeRepository.findByUserid(userid);
		}
    }
    
    @RequestMapping(value = "/route", method = RequestMethod.DELETE)
    public void deleteRoute(@RequestBody String data){
    	JsonObject dataBody = (JsonObject) (new JsonParser()).parse(data);
    	ObjectMapper mapper = new ObjectMapper();
    	ObjectId routeid,userid;
		try {
			userid = mapper.readValue(dataBody.get("userid").toString(), ObjectId.class);
			System.out.println("userid da rota a ser deletada: "+userid.toString());
			
			routeid = mapper.readValue(dataBody.get("routeid").toString(), ObjectId.class);
			System.out.println("routeid da rota a ser deletada: "+routeid.toString());
			
			routeRepository.delete(routeRepository.findByRouteid(routeid));			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = "/route/save", method = RequestMethod.POST)
    public List<Route> saveRoute(@RequestBody String data){
    	JsonObject dataBody = (JsonObject) (new JsonParser()).parse(data);
    	ObjectId userid = new ObjectId();
    	try {
    		System.out.println("salvando rota:" + dataBody.get("routename") + " "+ dataBody.get("startAddress") + " " + dataBody.get("endAddress") + " " + dataBody.get("encodedPolyline"));
			userid = new ObjectMapper().readValue(dataBody.get("userid").toString(), ObjectId.class);
			
			Route newRoute = new Route(dataBody.get("routename").getAsString(), dataBody.get("startAddress").getAsString(), dataBody.get("endAddress").getAsString(), dataBody.get("encodedPolyline").getAsString(), userid);
			routeRepository.save(newRoute);
			return routeRepository.findByUserid(userid);
		} catch (IOException e) {
			e.printStackTrace();
			return routeRepository.findByUserid(userid);
		}
    	
    }
}
