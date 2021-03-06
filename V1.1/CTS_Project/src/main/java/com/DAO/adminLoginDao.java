package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class adminLoginDao {
	
	@SuppressWarnings("rawtypes")
	public List loginQuery(String email, String password) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY ="From adminLoginPojo as o where o.email_ID=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		
		
		query.setParameter(0,email);
		query.setParameter(1,password);
	
		List list = query.list();

		
		return list;
		
	}
	

}
