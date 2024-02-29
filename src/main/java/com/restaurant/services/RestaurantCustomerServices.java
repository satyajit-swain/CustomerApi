package com.restaurant.services;

import java.util.List;

import com.restaurant.entities.Customers;

public interface RestaurantCustomerServices {
	
	void saveCustomer(Customers customer);
	
	List<Customers> getAllCustomers();
	
	void removeCustomer(int id);
}
