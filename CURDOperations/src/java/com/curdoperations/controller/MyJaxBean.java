package com.curdoperations.controller;


import org.codehaus.jackson.annotate.JsonProperty;

public class MyJaxBean{

	@JsonProperty 
	public String firstname;
	
	@JsonProperty 
	public String lastname;
	
	@JsonProperty
	public Long phonenumber;
	
	@JsonProperty
	public String emailid;
	
	@JsonProperty
	public char gender;
}
