package com.terrapay.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapay.main.model.Menu_Master;
import com.terrapay.main.model.Restaurant;
import com.terrapay.main.service.Menu_MasterService;
import com.terrapay.main.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	Menu_MasterService menu_MasterService;

	@PostMapping("/register")
	public String register(@RequestBody Restaurant restaurant) {
		restaurantService.saveRestaurant(restaurant);
		return "Restaurant register successfully";
	}

	@GetMapping("/login")
	public String login(@RequestBody Restaurant restaurant) {

		String status = restaurantService.findRestaurantByMobilenoAndEmail(restaurant);

		return status;
	}

	@GetMapping("/{pincode}")
	public ResponseEntity<List<Restaurant>> getRestaurantByPincode(@PathVariable("pincode") int pincode) {
		return new ResponseEntity(restaurantService.findRestaurantByPincode(pincode), HttpStatus.OK);
	}

	@GetMapping("/getAllMenu/{id}")
	public List<Menu_Master> findAll() {
		List<Menu_Master> list = menu_MasterService.getAll();
		return list;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
		try {
			this.restaurantService.deleteRestaurant(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public String updatedata(@RequestBody Restaurant r) {

		restaurantService.updatedata(r);
		return "Restaurant updated successfully";

	}

}
