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
public class Menu_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;

	@Length(min = 2, max = 20, message = "*Name must have at least 2 characters")
	@NotNull(message = "ItemName name is required.")
	private String itemName;

	private Double itemPrice;

	@Column(name = "description")
	private String itemDescription;
	
	//private int count;
	

}
