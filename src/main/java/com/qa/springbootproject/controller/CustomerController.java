package com.qa.springbootproject.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.service.CustomerService;

@RestController
public class CustomerController implements ControllerInterface<Customer> {

	private CustomerService service;

	// Dependency injection
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> createRequest(@RequestBody Customer body) {
		return new ResponseEntity<Customer>(this.service.create(body), HttpStatus.CREATED);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Customer>> readAllRequest() {
		return new ResponseEntity<List<Customer>>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Customer> readByIdRequest(@PathVariable Long id) {
		return new ResponseEntity<Customer>(this.service.readById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateByIdRequest(@PathVariable Long id, @RequestBody Customer body) {
		return new ResponseEntity<Customer>(this.service.updateById(id, body), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteByIdRequest(@PathVariable Long id) {
		return new ResponseEntity<Object>(this.service.deleteById(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
