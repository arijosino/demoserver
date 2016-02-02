package com.example.control;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.UserRepository;
import com.mongodb.util.JSON;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
		String s = "";
		for (User user : userRepository.findAll()) {
			System.out.println(user.getUsername());
			s+=user.getUsername() + '\n';
		}
        return s;
    }
	
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public User login(@RequestBody String data){
    	Map<String,String> dataBody = (Map<String,String>)JSON.parse(data);
    	System.out.println("requisição de login de:" + dataBody.get("username"));
    	User user = userRepository.findByUsername(dataBody.get("username"));
    	if(user != null &&
    			user.getPassword().equals(dataBody.get("password")) &&
    			user.getUuid().equals(dataBody.get("uuid"))){
    		System.out.println(user.getUserid().toString());
    		return user;
    	}
    	else{
    		return null;
    	}
    }
    
    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public int newUser(@RequestBody String data){
    	Map<String,String> dataBody = (Map<String,String>)JSON.parse(data);
    	System.out.println("requisição de cadastro de:" + dataBody.get("username"));
    	User user = userRepository.findByUsername(dataBody.get("username"));
    	if(user == null){
    		user = new User(dataBody.get("username"),dataBody.get("password"),dataBody.get("uuid"));
    		userRepository.save(user);
    		return 1;
    	}else{
    		return 0;
    	}
    }

}
