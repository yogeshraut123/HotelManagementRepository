package com.terrapay.main.service;

import com.terrapay.main.model.Customer;

public interface CustomerService {

	public void savecustomer(Customer customer);

	public String findCustomerByMobilenoAndEmail(Customer customer);

	public void updatedata(Customer c);

	public void deleteCustomer(int id);

	public Object findCustomerById(int id);

}
