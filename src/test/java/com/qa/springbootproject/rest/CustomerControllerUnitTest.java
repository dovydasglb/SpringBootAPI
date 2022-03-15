package com.qa.springbootproject.rest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.qa.springbootproject.controller.CustomerController;
import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.dto.CustomerDTO;
import com.qa.springbootproject.service.CustomerService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerUnitTest {

	@MockBean
	private CustomerService service;

	@Autowired
	private CustomerController controller;

	@Test
	void createRequestTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer("Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");
		CustomerDTO customerDTO = new CustomerDTO(6L, "Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");

		Mockito.when(this.service.create(customer)).thenReturn(customerDTO);

		// When - action or behaviour that we are testing
		ResponseEntity<CustomerDTO> response = this.controller.createRequest(customer);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.CREATED));

		Mockito.verify(this.service, Mockito.times(1)).create(customer);
	}

	@Test
	void readAllRequestTest() {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA"),
				new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ"),
				new CustomerDTO(3L, "Nicola", "Tesla", "tesla@tesla.com", "NW2 5AS"),
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"),
				new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD"));

		Mockito.when(this.service.readAll()).thenReturn(customerDTOList);

		// When - action or behaviour that we are testing
		ResponseEntity<List<CustomerDTO>> response = this.controller.readAllRequest();

		// Then - verify the output
		Assertions.assertThat(response)
				.isEqualTo(new ResponseEntity<List<CustomerDTO>>(customerDTOList, HttpStatus.OK));

		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	void readByIdRequestTest() {
		// Given - precondition or setup resources
		CustomerDTO customerDTO = new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");

		Mockito.when(this.service.readById(1L)).thenReturn(customerDTO);

		// When - action or behaviour that we are testing
		ResponseEntity<CustomerDTO> response = this.controller.readByIdRequest(1L);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK));

		Mockito.verify(this.service, Mockito.times(1)).readById(1L);
	}

	@Test
	void updateByIdRequestTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer("Marie", "Curie", "mcurie@gmail.com", "SW1 1AA");
		CustomerDTO customerDTO = new CustomerDTO(1L, "Marie", "Curie", "mcurie@gmail.com", "SW1 1AA");

		Mockito.when(this.service.updateById(1L, customer)).thenReturn(customerDTO);

		// When - action or behaviour that we are testing
		ResponseEntity<CustomerDTO> response = this.controller.updateByIdRequest(1L, customer);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.ACCEPTED));

		Mockito.verify(this.service, Mockito.times(1)).updateById(1L, customer);
	}

	@Test
	void deleteByIdRequestTest() {
		// Given - precondition or setup resources
		Mockito.when(this.service.deleteById(1L)).thenReturn(true);

		// When - action or behaviour that we are testing
		ResponseEntity<Object> response = this.controller.deleteByIdRequest(1L);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));

		Mockito.verify(this.service, Mockito.times(1)).deleteById(1L);
	}

	@Test
	void readAllByFirstNameRequestTest() {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ"),
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"));

		Mockito.when(this.service.readAllByFirstName("Charles")).thenReturn(customerDTOList);

		// When - action or behaviour that we are testing
		ResponseEntity<List<CustomerDTO>> response = this.controller.readAllByFirstNameRequest("Charles");

		// Then - verify the output
		Assertions.assertThat(response)
				.isEqualTo(new ResponseEntity<List<CustomerDTO>>(customerDTOList, HttpStatus.OK));

		Mockito.verify(this.service, Mockito.times(1)).readAllByFirstName("Charles");
	}

	@Test
	void readAllByLastNameRequestTest() {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"),
				new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD"));

		Mockito.when(this.service.readAllByLastName("Dickens")).thenReturn(customerDTOList);

		// When - action or behaviour that we are testing
		ResponseEntity<List<CustomerDTO>> response = this.controller.readAllByLastNameRequest("Dickens");

		// Then - verify the output
		Assertions.assertThat(response)
				.isEqualTo(new ResponseEntity<List<CustomerDTO>>(customerDTOList, HttpStatus.OK));

		Mockito.verify(this.service, Mockito.times(1)).readAllByLastName("Dickens");
	}
}
