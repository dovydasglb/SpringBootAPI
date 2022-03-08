package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.dto.CustomerDTO;
import com.qa.springbootproject.repo.CustomerRepo;

@Service
public class CustomerService implements ServiceInterface<CustomerDTO, Customer> {

	private CustomerRepo repo;

	private ModelMapper mapper;

	// Model mapping and repository dependency injection
	@Autowired
	public CustomerService(CustomerRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// Mapping to data transfer objects
	private CustomerDTO mapToDTO(Customer customer) {
		return this.mapper.map(customer, CustomerDTO.class);
	}

	// CRUD functionality
	public CustomerDTO create(Customer body) {
		Customer newCustomer = this.repo.save(body);
		return this.mapToDTO(newCustomer);
	}

	public List<CustomerDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public CustomerDTO readById(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}

	public CustomerDTO updateById(Long id, Customer body) {
		Optional<Customer> existingRecord = this.repo.findById(id);
		Customer updatedRecord = existingRecord.get();
		updatedRecord.setFirstName(body.getFirstName());
		updatedRecord.setLastName(body.getLastName());
		updatedRecord.setEmailAddress(body.getEmailAddress());
		updatedRecord.setPostCode(body.getPostCode());
		this.repo.save(updatedRecord);

		return this.mapToDTO(updatedRecord);
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
