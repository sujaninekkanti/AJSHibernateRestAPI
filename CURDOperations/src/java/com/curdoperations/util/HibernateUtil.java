package com.curdoperations.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		
		try{
			Configuration configuration = new Configuration();
			
			configuration.configure("com/curdoperations/cfgs/hibernate.cfg.xml");
			
			 sessionFactory = configuration.buildSessionFactory();
		}
		catch(Exception exception){
			System.out.println(exception.toString());
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
