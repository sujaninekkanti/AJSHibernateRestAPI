package com.curdoperations.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

	public void getConnection(){
		
		Configuration configuration = new Configuration();
		configuration.configure("com/curdoperations/cfgs/hibernate.cfg.xml");
		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
	}
}
