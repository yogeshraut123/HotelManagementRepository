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
import com.terrapay.main.service.Menu_MasterService;

@RestController
@RequestMapping("/menu")
public class MenuMasterController {

	@Autowired
	Menu_MasterService menu_masterService;

	@PostMapping("/AddMenu")
	public String register(@RequestBody Menu_Master menu_Master) {

		menu_masterService.saveMenu(menu_Master);
		return "Menu added successfully";

	}

	@GetMapping("/getAll")
	public List<Menu_Master> login() {
		List<Menu_Master> list = menu_masterService.getAll();
		return list;
	}

	@PutMapping("/Item/{menuId}")
	public String updatedata(@RequestBody Menu_Master m) {

		menu_masterService.updatedata(m);
		return "Menu Updated successfully";

	}

	@DeleteMapping("/{menuId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int menu_Master) {
		try {
			this.menu_masterService.deleteMenu(menu_Master);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
