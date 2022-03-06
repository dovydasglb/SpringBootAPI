package com.qa.springbootproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.repo.CustomerRepo;

@Service
public class CustomerService implements ServiceInterface<Customer>{

	private CustomerRepo repo;

	// Dependency injection
	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	public Customer create(Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer updateById(long id, Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteById(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
