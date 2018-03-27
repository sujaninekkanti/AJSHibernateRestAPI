package com.curdoperations.service;

import java.util.List;

import com.curdoperations.beans.Employee;
import com.curdoperations.bo.EmployeeBO;
import com.curdoperations.dao.EmployeeDAO;
import com.curdoperations.dao.EmployeeDAOImpl;


public class EmployeeServiceImpl implements EmployeeService {


	public int insertEmployee(EmployeeBO employeebo) {
		
		Employee employee = new Employee();
	
		System.out.println("inside insert service...");
		employee.setFirstName(employeebo.getFirstName());
		employee.setLastName(employeebo.getLastName());
		employee.setPhoneNumber(employeebo.getPhoneNumber());
		employee.setEmailId(employeebo.getEmailId());
		employee.setGender(employeebo.getGender());	
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		int result = employeeDAO.insertEmployee(employee);
		
		return result;
		
	}

	//@Override
	public int updateEmployeePhoneNumber(long phoneNumber,String firstName) {
		
	
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		int result = employeeDAO.updateEmployeePhoneNumber(phoneNumber, firstName);
		
		return result;
		
	}

	//@Override
	public List getAllEmployees() {
		
		System.out.println("inside list service...");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		List<Employee> employeelist = employeeDAO.getAllEmployees();
		
		return employeelist;
	}

	@Override
	public int deleteEmployee(String firstName) {

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		int result = employeeDAO.deleteEmployee(firstName);
		
		return result;
	}
	
}
