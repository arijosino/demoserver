package com.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection="user")
public class User {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private final ObjectId userid;
	private String username,password,uuid;

	public User(String username, String password, String uuid) {
		this.userid = new ObjectId();
		this.username = username;
		this.password = password;
		this.uuid = uuid;
	}

	public ObjectId getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
