package com.foodApp.model;

import lombok.Data;

@Data
public class ItemDTO {

    private String itemName;
	
	private Integer quantity;
	
	private Double costPerItem;

	public ItemDTO(String itemName, Integer quantity, Double costPerItem) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.costPerItem = costPerItem;
	}
	
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
}
