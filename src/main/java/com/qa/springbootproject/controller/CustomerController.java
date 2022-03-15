package com.qa.springbootproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.dto.CustomerDTO;
import com.qa.springbootproject.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController implements ControllerInterface<CustomerDTO, Customer> {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerDTO> createRequest(@Valid @RequestBody Customer body) {
		return new ResponseEntity<CustomerDTO>(this.service.create(body), HttpStatus.CREATED);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<CustomerDTO>> readAllRequest() {
		return new ResponseEntity<List<CustomerDTO>>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<CustomerDTO> readByIdRequest(@PathVariable Long id) {
		return new ResponseEntity<CustomerDTO>(this.service.readById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateByIdRequest(@PathVariable Long id, @Valid @RequestBody Customer body) {
		return new ResponseEntity<CustomerDTO>(this.service.updateById(id, body), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteByIdRequest(@PathVariable Long id) {
		this.service.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/readBy/firstName/{firstName}")
	public ResponseEntity<List<CustomerDTO>> readAllByFirstNameRequest(@PathVariable String firstName) {
		return new ResponseEntity<List<CustomerDTO>>(this.service.readAllByFirstName(firstName), HttpStatus.OK);
	}

	@GetMapping("/readBy/lastName/{lastName}")
	public ResponseEntity<List<CustomerDTO>> readAllByLastNameRequest(@PathVariable String lastName) {
		return new ResponseEntity<List<CustomerDTO>>(this.service.readAllByLastName(lastName), HttpStatus.OK);
	}
}
