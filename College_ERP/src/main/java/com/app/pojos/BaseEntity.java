package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//no table generated 
@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {

	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 12,unique=true)
	private String aadharCard;
	@Column(length = 20)
	private String password;
	@Column(length = 10)
	private String mobileNumber;
	@Column(length = 50,unique = true)
	private String email;
  
	
}
