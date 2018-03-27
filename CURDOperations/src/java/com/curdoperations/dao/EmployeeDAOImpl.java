package com.curdoperations.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.curdoperations.beans.Employee;
import com.curdoperations.util.HibernateUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	//@Override
	public int insertEmployee(Employee employee) {
				
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("insdie dao insert..");
		session.save(employee);
		
		transaction.commit();
		session.close();
		return 1;		
	}

	//@Override
	public int updateEmployeePhoneNumber(long phoneNumber,String firstName) {
		
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class,firstName);
		
		employee.setPhoneNumber(phoneNumber);
		
		session.update(employee);
		
		
		System.out.println("update successfully");
		
		transaction.commit();
		session.close();
		return 1;
	}
	
	
	
	public List<Employee> getAllEmployees(){
				
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("inside list dao");
		Criteria criteria = session.createCriteria(Employee.class);
		
		List employees = criteria.list();
		
		transaction.commit();
		session.close();
		
		return employees;
	}
	

}
