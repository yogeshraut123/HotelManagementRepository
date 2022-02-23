package com.terrapay.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String name;

	@Email(message = "Please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotBlank(message = "Please enter Email")
	@Column(unique = true)
	private String email;

	private String address;
	private int pincode;
	private String status;

	@JsonFormat(pattern = "HH:MM:SS", shape = Shape.NUMBER)
	private String restaurantopenTime;

	@JsonFormat(pattern = "HH:MM:SS", shape = Shape.NUMBER)
	private String restaurantcloseTime;

	@Size(min = 0, max = 10, message = "mobileno should be 10 digit")
	private long mobileno;

	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Menu_Master> menu_Masters;

}
