package com.foodApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class LoginData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
   
	@Column(unique = true)
    private Integer userId;
	
	@Email(message = "Please Enter the proper email")
	private String userName;
	
	private String password;
	
	
	

	public LoginData() {
		super();
	}

	public LoginData(Integer userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
