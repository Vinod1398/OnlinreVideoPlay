package com.poc.video.on.demand.mock.db;

import java.util.HashMap;
import java.util.Map;

import com.poc.video.on.demand.model.Purchase;
import com.poc.video.on.demand.model.User;

public class PurchaseDatabase {
	
	public static final Map<User, Purchase> PURCHASE_DATABSE = new HashMap<>();
	private PurchaseDatabase() {}

	public static Purchase getPurchases(User user) {
		return PURCHASE_DATABSE.get(user);
	}
	
	public static void addPurchase(Purchase purchase) {
		PURCHASE_DATABSE.put(purchase.getUser(), purchase);
	}
}
