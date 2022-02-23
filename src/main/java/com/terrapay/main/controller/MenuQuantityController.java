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
import com.terrapay.main.model.Menu_Quantity;
import com.terrapay.main.service.MenuQuantityService;

@RestController
@RequestMapping("/MenuQuantity")
public class MenuQuantityController {

	@Autowired
	MenuQuantityService menuQuantityService;

	@PostMapping("/addquantity")
	public String register(@RequestBody Menu_Quantity menuquantity) {
		menuQuantityService.saveMenuQuantity(menuquantity);
		return "Menu Quantity added successfully";
	}

	@GetMapping("/{menuQuantityId}")
	public ResponseEntity<List<Menu_Quantity>> getMenuQuantityBymenuQuantityId(
			@PathVariable("menuQuantityId") int menuQuantityId) {
		return new ResponseEntity(menuQuantityService.findMenu_QuantityIdByMenuQuantityId(menuQuantityId),
				HttpStatus.OK);
	}

	@PutMapping("/{menuQuantityId}")
	public String updatedata(@RequestBody Menu_Quantity menuQuantity) {

		menuQuantityService.updatedata(menuQuantity);
		return "Menu Quantity Updated successfully";

	}

	@DeleteMapping("/{menuQuantityId}")
	public ResponseEntity<HttpStatus> deleteMenuQuantity(@PathVariable int menuQuantityId) {
		try {
			this.menuQuantityService.deleteMenuQuantity(menuQuantityId);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
