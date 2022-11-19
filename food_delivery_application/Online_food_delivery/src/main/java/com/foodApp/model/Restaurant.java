package com.foodApp.model;



import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	
	@Column(unique = true)
	private String restaurantName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressid")
	private Address address;
	
	private String managerName;
	
	@Column(unique = true)
	private String contactNumber;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "restaurants")
	private Set<Item> items=new TreeSet<>();

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(managerName, other.managerName) && Objects.equals(restaurantId, other.restaurantId)
				&& Objects.equals(restaurantName, other.restaurantName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactNumber, managerName, restaurantId, restaurantName);
	}

	public Restaurant(String restaurantName, String managerName, String contactNumber) {
		super();
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}

	public Restaurant() {
		super();
	}
	
	
	
	
	

}
