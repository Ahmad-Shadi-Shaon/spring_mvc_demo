package com.shaon.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaon.springdemo.entity.Product;
import com.shaon.springdemo.entity.Purchase;
import com.shaon.springdemo.service.ProductService;
import com.shaon.springdemo.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	// need to inject our purchase service
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/list")
	public String listPurchases(Model theModel) {
		
		// get purchases from the service
		List<Purchase> thePurchases = purchaseService.getPurchases();
				
		// add the purchases to the model
		theModel.addAttribute("purchases", thePurchases);
		
		return "list-purchases";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Purchase thePurchase = new Purchase();
		
		List<Product> productlist = productService.getProducts(); 
		
		theModel.addAttribute("purchase", thePurchase);
		theModel.addAttribute("productlist", productlist);
		
		return "purchase-form";
	}
	
	@PostMapping("/savePurchase")
	public String savePurchase(@ModelAttribute("purchase") Purchase thePurchase) {
		
		// save the purchase using our service
		purchaseService.savePurchase(thePurchase);	
		
		return "redirect:/purchase/list";
	}
	
}










