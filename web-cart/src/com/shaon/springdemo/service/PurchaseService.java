package com.shaon.springdemo.service;

import java.util.List;

import com.shaon.springdemo.entity.Purchase;

public interface PurchaseService {

	public List<Purchase> getPurchases();

	public void savePurchase(Purchase thePurchase);

	
}
