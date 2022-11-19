package com.foodApp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurrentUserSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;
	
	@Column(unique = true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	
	
	
	public CurrentUserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}




	public CurrentUserSession() {
		super();
	}
	
	

}
