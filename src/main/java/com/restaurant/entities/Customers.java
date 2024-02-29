package com.restaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerID;
	
	@NotBlank(message = "Name field cannot be empty")
	private String name;
	
	@Email(message = "invalid email !",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@NotBlank(message = "Email field cannot be empty")
	private String email;
	
	@NotBlank(message = "phone No. field cannot be empty")
	private String phNo;
}
