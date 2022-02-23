package com.terrapay.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Menu_Quantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuQuantityId;

	@Column(name = "quantity", nullable = false)
	@Min(value = 0, message = "*Quantity has to be non negative number")
	private int quantity;

	private String status;

}
