package com.DAO;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.POJO.customerEntryPojo;

public class customerEntryDao {
	@SuppressWarnings("rawtypes")
	public boolean customerEntryDao1(String name, String password, String phone, String address) {
	customerEntryPojo obj =new customerEntryPojo();
	boolean entered = true;
	
	SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	
	String SQL_QUERY ="From customerEntryPojo as o where o.customer_Name=? and o.customer_Phone=?";
	Query query = session.createQuery(SQL_QUERY);
	
	
	query.setParameter(0,name);
	query.setParameter(1,phone);

	List list = query.list();
	
	
	
	if ((list == null) || (list.size() == 0)) {
		
		obj.setCustomer_ID(0);
		 obj.setCustomer_Name(name);
		obj.setCustomer_Phone(phone);
		obj .setCustomer_Password(password);
		obj.setCustomer_Address(address);
		
		Transaction tx = session.beginTransaction();
		session.persist(obj);
		
		tx.commit();
		
		return entered;
		
	}

	else
	
	{
	
		entered=false;
		return entered;

	}
	
	
	
	
}
}