package com.restaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entities.Customers;
import com.restaurant.services.RestaurantServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantServices restroService;
	
	@PostMapping("/booking")
	public ResponseEntity<Customers> save(@RequestBody Customers customer){
		
		
		restroService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		
	}
	
	@GetMapping("/booked")
	public ResponseEntity<List<Customers>> bookedCustomers(Model model) {
		
		List<Customers> allCustomers = restroService.getAllCustomers();
		return ResponseEntity.ok(allCustomers);
		
	}
	
	@DeleteMapping("/booked/{Id}")
	public ResponseEntity<Customers> deleteCustomer(@PathVariable int Id) {
		
		restroService.removeCustomer(Id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	
	/*
	 
	@PostMapping("/booking")
	public String save(@Valid @ModelAttribute("customer") Customers customer,BindingResult result,Model model){
		try {
			if(result.hasErrors()) {
				
				model.addAttribute("customer", customer);
				return "booking";
			}
			
			restroService.saveCustomer(customer);
			return "bookedPage"; 
			
		} catch (Exception e) {
			e.printStackTrace();
			return "booking";
			
		}
		
	}
	
	@GetMapping("/booked")
	public String bookedCustomers(Model model) {
		
		List<Customers> allCustomers = restroService.getAllCustomers();
		return "bookedPage";
		
	}
	
	@deleteMapping("/booked")
	public String deleteCustomer(@ModelAttribute("customer") Customers customer,Model model) {
		
		restroService.removeCustomer(customer.getCustomerID());
		return "bookedPage";
		
	}
	
	*/
	
}
