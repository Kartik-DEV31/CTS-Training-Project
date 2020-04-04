package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

import com.POJO.productsCRUDPojo;


public class productsCRUDDao {

	@SuppressWarnings("rawtypes")
	public List displayData() {
		
SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY ="From productsCRUDPojo";
		Query query = session.createQuery(SQL_QUERY);
		
		
	
		List list = query.list();
		
		return list;
	}

	public void insertData(String name, String cost, String picture, int id) {
		
		productsCRUDPojo obj =new productsCRUDPojo();
		
		SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		
		
		
		obj.setProduct_ID(0);
		 obj.setProduct_Name(name);
		obj.setProduct_Picture(picture);
		obj .setProduct_Cost(cost);
		
		
		Transaction tx = session.beginTransaction();
		session.persist(obj);
		
		tx.commit();
		
		
		
		
	}
	
	
	public void DeleteData(int id) {
		
		productsCRUDPojo obj =new productsCRUDPojo();
		
		SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		String HQLD = "delete from productsCRUDPojo p where p.product_ID=?";
        Query query = session.createQuery(HQLD);
        query.setParameter(0, id);
       query.executeUpdate();
		
		
       Transaction tx = session.beginTransaction();
       tx.commit();
       		
		
		
		
		
		
		
		
	}

	public void updateProduct(String cost , String name) {

		SessionFactory sessionFactory = new Configuration().configure("CTS_hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update productsCRUDPojo set product_Cost =? where product_Name =?");
query.setParameter(0, cost);
query.setParameter(1, name);
query.executeUpdate();

Transaction tx = session.beginTransaction();
tx.commit();
		
	}
	
	
	

}
