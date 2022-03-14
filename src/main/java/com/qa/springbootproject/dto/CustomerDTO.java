package com.qa.springbootproject.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String postCode;
}
