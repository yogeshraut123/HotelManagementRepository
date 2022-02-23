package com.terrapay.main.serviceImpl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.terrapay.main.model.Customer;
import com.terrapay.main.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Mock
	CustomerRepository customerRepository;

	@Test
	public void testSavecustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setPassword("test");

		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		customerServiceImpl.savecustomer(customer);
		assertTrue(true);
	}

	@Test
	public void testFindCustomerByPincode() {
		Mockito.when(customerRepository.findCustomerById(1)).thenReturn(new ArrayList<>());
		List<Customer> res = customerServiceImpl.findCustomerById(1);
		assertTrue(true);
	}

	@Test
	public void testUpdatedata() {
		Customer customer = new Customer();

		customer.setId(1);

		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		customerServiceImpl.updatedata(customer);
		assertTrue(true);

	}

	@Test
	public void testFindCustomerByMobilenoAndEmail() {

		Customer customer = new Customer();

		customer.setId(1);
		customer.setEmail("test@gmail.com");
		customer.setMobileno(992);
		customer.setPassword("123");
		Mockito.lenient().when(customerRepository.findCustomerByEmail(Mockito.anyString())).thenReturn(customer);
		Mockito.lenient().when(customerRepository.findCustomerByMobileno(Mockito.anyLong())).thenReturn(customer);
		String res = customerServiceImpl.findCustomerByMobilenoAndEmail(customer);
		assertTrue(true);

	}

	@Test
	public void testDeleteCustomer() {
		Mockito.doNothing().when(customerRepository).deleteById(Mockito.anyInt());
		customerServiceImpl.deleteCustomer(1);
		assertTrue(true);
	}

}
