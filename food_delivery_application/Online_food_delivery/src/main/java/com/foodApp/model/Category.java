package com.foodApp.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(unique = true)
	private String categoryName;
	

	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Category() {
		super();
	}
		

}
