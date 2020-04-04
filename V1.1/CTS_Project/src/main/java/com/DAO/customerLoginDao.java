package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class customerLoginDao {

	

	@SuppressWarnings("rawtypes")
	public List loginQuery(String name, String password) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY ="From customerEntryPojo as o where o.customer_Name=? and o.customer_Password=?";
		Query query = session.createQuery(SQL_QUERY);
		
		
		query.setParameter(0,name);
		query.setParameter(1,password);
	
		List list = query.list();

		
		return list;
		
	}
	
	

}
