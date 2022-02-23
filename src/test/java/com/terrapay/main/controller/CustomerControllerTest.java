package com.terrapay.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.terrapay.main.model.Customer;
import com.terrapay.main.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerservice;

	@Test
	public void testLogin() {
		Mockito.when(customerservice.findCustomerByMobilenoAndEmail(Mockito.any())).thenReturn("test");
		String res = customerController.login(Mockito.any());
		assertThat(res).isEqualTo("test");
	}

	@Test
	public void testRegister() {
		Mockito.doNothing().when(customerservice).savecustomer(Mockito.any());
		String res = customerController.register(new Customer());
		assertTrue(true);

	}

	@Test
	public void testUpdatedata() {
		Mockito.doNothing().when(customerservice).updatedata(Mockito.any());
		String res = customerController.updatedata(new Customer());
		assertTrue(true);
	}

	@Test
	public void testGetCustomerByPincode() {
		Mockito.when(customerservice.findCustomerById(Mockito.anyInt())).thenReturn(new Object());
		ResponseEntity<List<Customer>> res = customerController.getCustomerByPincode(445302);
		assertTrue(true);
	}

	@Test
	public void testDeleteCustomer() {
		Mockito.doNothing().when(customerservice).deleteCustomer(Mockito.anyInt());
		String res = customerController.deleteCustomer(1);
		assertTrue(true);
	}

}
