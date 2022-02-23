package com.terrapay.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "firstname", nullable = false)
	private String firstname;

	@Column(name = "lastname", nullable = false)
	private String lastname;

	@Email(message = "Please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotBlank(message = "Please enter Email")
	@Column(unique = true)
	private String email;

	private String address;
	private int pincode;

	@Size(min = 0, max = 10, message = "mobileno should be 10 digit")
	private long mobileno;

	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Menu_Master> menu_master;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Menu_Quantity> menu_quantity;

}
