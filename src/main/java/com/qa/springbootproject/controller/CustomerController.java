package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.service.CustomerService;
import com.qa.springbootproject.service.ServiceCRUD;

@RestController
public class CustomerController implements ServiceCRUD<Customer>{

	private CustomerService service;

	// Dependency injection
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseEntity<Customer> create(Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Customer>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Customer> readById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Customer> updateById(long id, Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	// CRUD
//	
//	// Create
//	@PostMapping("/create")
//	public ResponseEntity<Customer> createRequest(@RequestBody Customer customer) {
//		return null;
//	}
//	
//	// Read
//	@GetMapping("/readAll")
//	public ResponseEntity<List<Customer>> readAllRequest() {
//		return null;
//	}
//	
//	@GetMapping("/read/{id}")
//	public ResponseEntity<Customer> readByIdRequest(@PathVariable long id) {
//		return null;
//	}
//	
//	// Update
//	@PutMapping("/update")
//	public ResponseEntity<Customer> updateByIdRequest() {
//		
//	}
}
