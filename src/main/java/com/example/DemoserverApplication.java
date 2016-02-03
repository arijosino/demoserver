package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Route;
import com.example.model.RouteRepository;
import com.example.model.User;
import com.example.model.UserRepository;

@SpringBootApplication
public class DemoserverApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RouteRepository routeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoserverApplication.class, args);
	}
	
	@Override
	public void run(String... args){
		userRepository.deleteAll();
		User testuser = new User("abc","202cb962ac59075b964b07152d234b70","");
		userRepository.save(testuser);//abc 123
		
		routeRepository.deleteAll();
//		Route testroute = new Route("testroute","fortaleza","papicu","polyline",testuser.getUserid());
//		routeRepository.save(testroute);
//		Route testroute2 = new Route("testroute2","fortaleza","papicu","polyline",testuser.getUserid());
//		routeRepository.save(testroute2);
	}
}
