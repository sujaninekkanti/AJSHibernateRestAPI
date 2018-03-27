package com.curdoperations.service;

import java.util.List;

import com.curdoperations.bo.EmployeeBO;

public interface EmployeeService {

	public int insertEmployee(EmployeeBO employeebo);
	
	public int updateEmployeePhoneNumber(long phoneNumber,String firstName);
	
	public List getAllEmployees();
}
