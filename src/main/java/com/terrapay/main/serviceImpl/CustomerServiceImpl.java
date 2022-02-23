package com.terrapay.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrapay.main.encodedecode.Converter;
import com.terrapay.main.model.Customer;
import com.terrapay.main.repository.CustomerRepository;
import com.terrapay.main.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerrepository;

	@Override
	public void savecustomer(Customer customer) {

		String str = com.terrapay.main.encodedecode.Converter.encodepassword(customer.getPassword());
		customer.setPassword(str);

		customerrepository.save(customer);

	}

	@Override
	public List<Customer> findCustomerById(int id) {

		return customerrepository.findCustomerById(id);
	}

	@Override
	public void updatedata(Customer c) {
		customerrepository.save(c);

	}

	@Override
	public String findCustomerByMobilenoAndEmail(Customer customer) {

		String login = null;
		Customer c = null;

		if (customer.getEmail() != null && !customer.getEmail().equalsIgnoreCase("")) {
			c = customerrepository.findCustomerByEmail(customer.getEmail());
		} else if (customer.getMobileno() != 0l) {
			c = customerrepository.findCustomerByMobileno(customer.getMobileno());
		}

		if (c != null) {
			String password = Converter.decodepassword(c.getPassword());
			if (customer.getPassword().contains(password)) {
				login = "Successfully login";
			} else {

				login = "failed to login";
			}

		} else {
			login = "failed to login";
		}

		return login;

	}

	@Override
	public void deleteCustomer(int id) {

		customerrepository.deleteById(id);
	}

}
