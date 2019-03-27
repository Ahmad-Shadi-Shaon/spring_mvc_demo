package com.shaon.springdemo.dao;

import java.util.List;

import com.shaon.springdemo.entity.Purchase;

public interface PurchaseDAO {

	public List<Purchase> getPurchases();

	public void savePurchase(Purchase thePurchase);

	
}
