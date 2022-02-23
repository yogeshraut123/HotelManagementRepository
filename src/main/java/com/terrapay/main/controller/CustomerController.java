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

import com.terrapay.main.model.Customer;
import com.terrapay.main.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@PostMapping("/save")
	public String register(@RequestBody Customer customer) {

		customerservice.savecustomer(customer);
		return "Data register successfully";
	}

	@GetMapping("/login")
	public String login(@RequestBody Customer customer) {

		String status = customerservice.findCustomerByMobilenoAndEmail(customer);

		return status;
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Customer>> getCustomerByPincode(@PathVariable("id") int id) {
		return new ResponseEntity(customerservice.findCustomerById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public String updatedata(@RequestBody Customer c) {

		customerservice.updatedata(c);
		return "update data successfully";

	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerservice.deleteCustomer(id);

		return "Customer deleted successfully";
	}

}
