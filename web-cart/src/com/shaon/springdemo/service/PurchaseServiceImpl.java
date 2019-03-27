package com.shaon.springdemo.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shaon.springdemo.dao.PurchaseDAO;
import com.shaon.springdemo.entity.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	// need to inject purchase dao
	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Override
	@Transactional
	public List<Purchase> getPurchases() {
		return purchaseDAO.getPurchases();
	}

	@Override
	@Transactional
	public void savePurchase(Purchase thePurchase) {
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		thePurchase.setPurchaseDate(timestamp);

		purchaseDAO.savePurchase(thePurchase);
	}

}





