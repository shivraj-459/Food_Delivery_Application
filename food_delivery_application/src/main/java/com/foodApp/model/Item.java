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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@Column(unique = true)
	private String itemName;
	
	private Integer quantity;
	
	private Double costPerItem;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "categoryId")
	@JsonIgnore
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Restaurant> restaurants=new TreeSet<>();

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(category, costPerItem, itemId, itemName, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(category, other.category) && Objects.equals(costPerItem, other.costPerItem)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(quantity, other.quantity);
	}

	
	
	public Item(String itemName, Integer quantity, Double costPerItem) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.costPerItem = costPerItem;
	
	}

	public Item() {
		super();
	}
	
	
	

	

}
