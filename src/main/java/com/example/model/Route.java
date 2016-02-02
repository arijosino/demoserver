package com.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection="route")
public class Route {
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private final ObjectId routeid;
	private String routename,startAddress,endAddress,encodedPolyline;
	@JsonSerialize(using = ToStringSerializer.class)
    private final ObjectId userid;
    
	public Route(String routename, String startAddress, String endAddress, String encodedPolyline, ObjectId userid) {
		this.routename = routename;
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.encodedPolyline = encodedPolyline;
		this.userid = userid;
		this.routeid = new ObjectId();
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public String getEncodedPolyline() {
		return encodedPolyline;
	}

	public void setEncodedPolyline(String encodedPolyline) {
		this.encodedPolyline = encodedPolyline;
	}

	public ObjectId getUserid() {
		return userid;
	}

	public ObjectId getRouteid() {
		return routeid;
	}

}
