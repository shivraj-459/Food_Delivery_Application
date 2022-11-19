package com.foodApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.Data;


@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String mobileNumber;
	
	private String password;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressid")
	private Address address;
	
	private String email;

	
	public Customer() {
		super();
	}


	public Customer(Integer customerId, String firstName, String lastName, Integer age, Gender gender,
			String mobileNumber, String password, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
	}
	
	
	
	

}
