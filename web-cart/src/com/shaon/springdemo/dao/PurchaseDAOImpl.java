package com.shaon.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shaon.springdemo.entity.Purchase;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Purchase> getPurchases() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("hello");

		// create a query ... sort by last name
		Query<Purchase> theQuery = currentSession.createQuery("from Purchase order by purchaseDate desc", Purchase.class);
		
		System.out.println("hello");

		// execute query and get result list
		List<Purchase> purchases = theQuery.getResultList();

		// return the results
		return purchases;
	}

	@Override
	public void savePurchase(Purchase thePurchase) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the purchase ... finally LOL
		currentSession.saveOrUpdate(thePurchase);

	}

	
	

}
