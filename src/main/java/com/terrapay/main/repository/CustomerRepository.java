package com.terrapay.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terrapay.main.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


	public Customer findCustomerByEmail(String email);

	public Customer findCustomerByMobileno(long mobileno);

	public List<Customer> findCustomerById(int id);

}
