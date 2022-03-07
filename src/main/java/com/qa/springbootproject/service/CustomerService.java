package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.repo.CustomerRepo;

@Service
public class CustomerService implements ServiceInterface<Customer> {

	private CustomerRepo repo;

	// Dependency injection
	@Autowired
	public CustomerService(CustomerRepo repo) {
		super();
		this.repo = repo;
	}

	public Customer create(Customer body) {
		return this.repo.save(body);
	}

	public List<Customer> readAll() {
		return this.repo.findAll();
	}

	public Customer readById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}

	public Customer updateById(Long id, Customer body) {
		Optional<Customer> existingRecord = this.repo.findById(id);
		Customer updatedRecord = existingRecord.get();
		updatedRecord.setFirstName(body.getFirstName());
		updatedRecord.setLastName(body.getLastName());
		updatedRecord.setEmailAddress(body.getEmailAddress());
		updatedRecord.setPostCode(body.getPostCode());

		return this.repo.save(updatedRecord);
	}

	public boolean deleteById(Long id) {
		Optional<Customer> existingRecord = this.repo.findById(id);

		if (existingRecord.isPresent()) {
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		} else
			return false;
	}

}
