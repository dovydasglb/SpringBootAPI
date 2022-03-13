package com.qa.springbootproject.rest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootproject.domain.Customer;
import com.qa.springbootproject.dto.CustomerDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:customers-schema.sql",
		"classpath:customers-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class CustomerControllerIntegrationTest {

	private String defaultURL = "http://localhost:8080/customer";

	@Autowired
	private MockMvc mock;

	@Autowired
	private ModelMapper mapper;

	private CustomerDTO mapToDTO(Customer customer) {
		return this.mapper.map(customer, CustomerDTO.class);
	}

	@Autowired
	private ObjectMapper jsonifier;

	@Test
	void createRequestTest() throws Exception {
		// Given - precondition or setup resources
		Customer customer = new Customer(6L, "Isaac", "Newton", "newton@yahoo.com", "BH3 1SW");
		CustomerDTO customerDTO = this.mapToDTO(customer);

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST,
				defaultURL + "/create");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(customerDTO));
		mockRequest.accept(MediaType.APPLICATION_JSON);

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTO));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	void readAllRequestTest() throws Exception {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA"),
				new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ"),
				new CustomerDTO(3L, "Nicola", "Tesla", "tesla@tesla.com", "NW2 5AS"),
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"),
				new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD"));

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				defaultURL + "/readAll");

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTOList));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	void readByIdRequestTest() throws Exception {
		// Given - precondition or setup resources
		CustomerDTO customerDTO = new CustomerDTO(1L, "Albert", "Einstein", "einstein@gmail.com", "EC1 2AA");

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				defaultURL + "/read/1");

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTO));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	void updateByIdRequestTest() throws Exception {
		// Given - precondition or setup resources
		CustomerDTO customerDTO = new CustomerDTO(1L, "Marie", "Curie", "mcurie@gmail.com", "SW1 1AA");

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
				defaultURL + "/update/1");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.jsonifier.writeValueAsString(customerDTO));
		mockRequest.accept(MediaType.APPLICATION_JSON);

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTO));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	void deleteByIdRequestTest() throws Exception {
		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				defaultURL + "/delete/1");

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

	@Test
	void readAllByFirstNameRequestTest() throws Exception {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(2L, "Charles", "Darwin", "darwin@mail.com", "SW2 5JZ"),
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"));

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				defaultURL + "/readBy/firstName/Charles");

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTOList));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	@Test
	void readAllByLastNameRequestTest() throws Exception {
		// Given - precondition or setup resources
		List<CustomerDTO> customerDTOList = List.of(
				new CustomerDTO(4L, "Charles", "Dickens", "dickens@gmail.com", "RH2 2EE"),
				new CustomerDTO(5L, "Alfred", "Dickens", "adickens@mail.com", "SW1 4AD"));

		// When - action or behaviour that we are testing
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
				defaultURL + "/readBy/lastName/Dickens");

		// Then - verify the output
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(customerDTOList));
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
}
