package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private Integer id;
	
	@NotNull(message = "Name should Not Be Null")
	private String name;
	
	@NotNull(message = "password should Not Be Null")
	private String password;
	
	@NotNull(message = "Address should Not Be Null")
	private String address;
	
	@Email
	@NotNull(message = "Email should Not Be Null")
	private String email;
}
