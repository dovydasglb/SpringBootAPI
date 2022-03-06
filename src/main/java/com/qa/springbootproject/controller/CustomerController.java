package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.service.CustomerService;

@RestController
public class CustomerController implements ControllerInterface<Customer>{

	private CustomerService service;

	// Dependency injection
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Customer>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Customer> readById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateById(@PathVariable long id, @RequestBody Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
