package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.dto.CustomerDTO;
import com.qa.springbootproject.exception.ResourceNotFoundException;
import com.qa.springbootproject.repo.CustomerRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerServiceUnitTest {

	@MockBean
	private CustomerRepo repo;

	@MockBean
	private ModelMapper mapper;

	@Autowired
	private CustomerService service;

	@Test
	void createTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer("Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");
		Customer createdCustomer = new Customer(6L, "Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");
		CustomerDTO customerDTO = new CustomerDTO(6L, "Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");

		Mockito.when(this.repo.save(customer)).thenReturn(createdCustomer);
		Mockito.when(this.mapper.map(createdCustomer, CustomerDTO.class)).thenReturn(customerDTO);

		// When - action or behaviour that we are testing
		CustomerDTO response = this.service.create(customer);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(customerDTO);
	}

	@Test
	void readAllTest() {
		// Given - precondition or setup resources
		Customer customer1 = new Customer(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");
		Customer customer2 = new Customer(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ");
		Customer customer3 = new Customer(3L, "Nicola", "Tesla", "tesla@tesla.com", "NW2 5AS");
		Customer customer4 = new Customer(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		Customer customer5 = new Customer(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD");
		List<Customer> customerList = List.of(customer1, customer2, customer3, customer4, customer5);
		CustomerDTO customer1DTO = new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");
		CustomerDTO customer2DTO = new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ");
		CustomerDTO customer3DTO = new CustomerDTO(3L, "Nicola", "Tesla", "tesla@tesla.com", "NW2 5AS");
		CustomerDTO customer4DTO = new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		CustomerDTO customer5DTO = new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD");
		List<CustomerDTO> customerDTOList = List.of(customer1DTO, customer2DTO, customer3DTO, customer4DTO,
				customer5DTO);

		Mockito.when(this.repo.findAll()).thenReturn(customerList);
		Mockito.when(this.mapper.map(customer1, CustomerDTO.class)).thenReturn(customer1DTO);
		Mockito.when(this.mapper.map(customer2, CustomerDTO.class)).thenReturn(customer2DTO);
		Mockito.when(this.mapper.map(customer3, CustomerDTO.class)).thenReturn(customer3DTO);
		Mockito.when(this.mapper.map(customer4, CustomerDTO.class)).thenReturn(customer4DTO);
		Mockito.when(this.mapper.map(customer5, CustomerDTO.class)).thenReturn(customer5DTO);

		// When - action or behaviour that we are testing
		List<CustomerDTO> response = this.service.readAll();

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(customerDTOList);
	}

	@Test
	void readByIdTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");
		CustomerDTO customerDTO = new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(customer));
		Mockito.when(this.mapper.map(customer, CustomerDTO.class)).thenReturn(customerDTO);

		// When - action or behaviour that we are testing
		CustomerDTO response = this.service.readById(1L);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(customerDTO);
	}

	@Test
	void updateByIdTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");
		Customer updatedCustomer = new Customer(1L, "Marie", "Curie", "mcurie@gmail.com", "SW1 1AA");
		CustomerDTO updatedCustomerDTO = new CustomerDTO(1L, "Marie", "Curie", "mcurie@gmail.com", "SW1 1AA");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(customer));
		Mockito.when(this.repo.save(updatedCustomer)).thenReturn(updatedCustomer);
		Mockito.when(this.mapper.map(updatedCustomer, CustomerDTO.class)).thenReturn(updatedCustomerDTO);

		// When - action or behaviour that we are testing
		CustomerDTO response = this.service.updateById(1L, updatedCustomer);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(updatedCustomerDTO);
	}

	@Test
	void deleteByIdTest() {
		// Given - precondition or setup resources
		Customer customer = new Customer(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(customer));

		// When - action or behaviour that we are testing
		boolean response = this.service.deleteById(1L);

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(true);
	}

	@Test
	void readAllByFirstNameTest() {
		// Given - precondition or setup resources
		Customer customer2 = new Customer(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ");
		Customer customer4 = new Customer(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		List<Customer> customerList = List.of(customer2, customer4);
		CustomerDTO customer2DTO = new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ");
		CustomerDTO customer4DTO = new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		List<CustomerDTO> customerDTOList = List.of(customer2DTO, customer4DTO);

		Mockito.when(this.repo.readAllByFirstName("Charles")).thenReturn(customerList);
		Mockito.when(this.mapper.map(customer2, CustomerDTO.class)).thenReturn(customer2DTO);
		Mockito.when(this.mapper.map(customer4, CustomerDTO.class)).thenReturn(customer4DTO);

		// When - action or behaviour that we are testing
		List<CustomerDTO> response = this.service.readAllByFirstName("Charles");

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(customerDTOList);
	}

	@Test
	void readAllByLastNameTest() {
		// Given - precondition or setup resources
		Customer customer4 = new Customer(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		Customer customer5 = new Customer(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD");
		List<Customer> customerList = List.of(customer4, customer5);
		CustomerDTO customer4DTO = new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE");
		CustomerDTO customer5DTO = new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD");
		List<CustomerDTO> customerDTOList = List.of(customer4DTO, customer5DTO);

		Mockito.when(this.repo.readAllByLastName("Dickens")).thenReturn(customerList);
		Mockito.when(this.mapper.map(customer4, CustomerDTO.class)).thenReturn(customer4DTO);
		Mockito.when(this.mapper.map(customer5, CustomerDTO.class)).thenReturn(customer5DTO);

		// When - action or behaviour that we are testing
		List<CustomerDTO> response = this.service.readAllByLastName("Dickens");

		// Then - verify the output
		Assertions.assertThat(response).isEqualTo(customerDTOList);
	}

	@Test
	void readByIdResourceNotFoundExceptionTest() {
		ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
				() -> this.service.readById(1L), "Assertion failed");
		assertEquals(thrown.getMessage(), "Customer with id: 1 not found");
	}

	@Test
	void updateByIdResourceNotFoundExceptionTest() {
		Customer customer = new Customer("Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");
		ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
				() -> this.service.updateById(1L, customer), "Assertion failed");
		assertEquals(thrown.getMessage(), "Customer with id: 1 not found");
	}

	@Test
	void deleteByIdResourceNotFoundExceptionTest() {
		ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
				() -> this.service.deleteById(1L), "Assertion failed");
		assertEquals(thrown.getMessage(), "Customer with id: 1 not found");
	}

	@Test
	void readAllByFirstNameResourceNotFoundExceptionTest() {
		ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
				() -> this.service.readAllByFirstName("Albert"), "Assertion failed");
		assertEquals(thrown.getMessage(), "Customer record with first name: Albert does not exist");
	}

	@Test
	void readAllByLastNameResourceNotFoundExceptionTest() {
		ResourceNotFoundException thrown = assertThrows(ResourceNotFoundException.class,
				() -> this.service.readAllByLastName("Dickinson"), "Assertion failed");
		assertEquals(thrown.getMessage(), "Customer record with last name: Dickinson does not exist");
	}
	
	
}
