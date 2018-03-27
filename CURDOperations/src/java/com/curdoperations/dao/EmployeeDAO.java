package com.curdoperations.dao;

import java.util.List;

import com.curdoperations.beans.Employee;



public interface EmployeeDAO {

	public int insertEmployee(Employee employee);
	
	public int updateEmployeePhoneNumber(long phoneNumber,String firstName);
	
	public List getAllEmployees();
	
	public int deleteEmployee(String firstName);
}
