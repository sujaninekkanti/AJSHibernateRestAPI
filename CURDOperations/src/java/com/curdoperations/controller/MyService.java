package com.curdoperations.controller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.curdoperations.bo.EmployeeBO;
import com.curdoperations.service.EmployeeService;
import com.curdoperations.service.EmployeeServiceImpl;

@Path("rest")
public class MyService {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registration")
	public String createUser(MyJaxBean input) throws Exception {
		
		EmployeeBO employeebo = new EmployeeBO();

		employeebo.setFirstName(input.firstname);
		employeebo.setLastName(input.lastname);
		employeebo.setPhoneNumber(input.phonenumber);
		employeebo.setEmailId(input.emailid);
		employeebo.setGender(input.gender);
		
		EmployeeService employeeservice = new EmployeeServiceImpl();

		int result = employeeservice.insertEmployee(employeebo);
	
		if (result == 1) { 
			return "SUCCESS";
			
		} 
		return "FAILURE";
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public String updateUser(MyJaxBean input) throws Exception{
		
		EmployeeService employeeservice = new EmployeeServiceImpl();
		
		int result = employeeservice.updateEmployeePhoneNumber(input.phonenumber,input.firstname);
		
		if(result ==1){
			return "SUCCESS";
		}
		
		return "FAILURE..";
		
	}
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllEmployees() throws Exception{
		
		EmployeeService employeeservice = new EmployeeServiceImpl();
		
		List<MyJaxBean> empbo = employeeservice.getAllEmployees();
		
		return empbo;
		
	}
}
