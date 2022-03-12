package com.qa.springbootproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	@NotNull
	@NotBlank(message = "First name must not be blank")
	@Size(min = 2, message = "First name must be at least 2 characters long")
	@Size(max = 30, message = "First name length exceeds limits")
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@NotBlank(message = "Last name must not be blank")
	@Size(min = 2, message = "First name must be at least 2 characters long")
	@Size(max = 30, message = "First name length exceeds limits")
	private String lastName;

	@Column(name = "email_address")
	@NotNull
	@NotBlank(message = "Email address must not be blank")
	@Size(min = 6, message = "Email address must be at least 6 characters long")
	@Size(max = 254, message = "Email length exceeds limits")
	@Email(message = "Invalid email address")
	private String emailAddress;

	@Column(name = "post_code")
	@NotNull
	@NotBlank(message = "Post code must not be blank")
	@Size(min = 6, message = "Invalid postcode")
	@Size(max = 8, message = "Invalid postcode")
	@Pattern(regexp = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$", message = "Invalid post code")
	private String postCode;

	public Customer(String firstName, String lastName, String emailAddress, String postCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.postCode = postCode;
	}

}
