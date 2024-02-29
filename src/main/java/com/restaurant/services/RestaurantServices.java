package com.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entities.Customers;
import com.restaurant.repositories.RestaurantRepository;

@Service
public class RestaurantServices implements RestaurantCustomerServices{
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Override
	public void saveCustomer(Customers customer) {

		restaurantRepo.save(customer);
	}

	@Override
	public List<Customers> getAllCustomers() {
		
		List<Customers> allCustomers = (List<Customers>) restaurantRepo.findAll();
		return allCustomers;
	}

	@Override
	public void removeCustomer(int id) {
		
		restaurantRepo.deleteById(id);
		
	}

}
