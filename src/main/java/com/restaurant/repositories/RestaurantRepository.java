package com.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.Customers;

@Repository
public interface RestaurantRepository extends CrudRepository<Customers, Integer>{
	
}
