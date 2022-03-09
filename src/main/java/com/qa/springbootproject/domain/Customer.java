package com.qa.springbootproject.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column(name = "first_name")
	@NotBlank(message = "First name must not be blank")
	@Size(min = 2, message = "First name must be at least 2 characters long")
	@Size(max = 30, message = "First name length exceeds limits")
	private String firstName;

	
	@Column(name = "last_name")
	@NotBlank(message = "Last name must not be blank")
	@Size(min = 2, message = "First name must be at least 2 characters long")
	@Size(max = 30, message = "First name length exceeds limits")
	private String lastName;

	
	@Column(name = "email_address")
	@NotBlank(message = "Email address must not be blank")
	@Size(min = 6, message = "Email address must be at least 6 characters long")
	@Size(max = 254, message = "Email length exceeds limits")
	@Email(message = "Invalid email address")
	private String emailAddress;

	@Column(name = "post_code")
	@NotBlank(message = "Post code must not be blank")
	@Size(min = 6, message = "Invalid postcode")
	@Size(max = 8, message = "Invalid postcode")
	@Pattern(regexp = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$", message = "Invalid post code")
	private String postCode;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String emailAddress, String postCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.postCode = postCode;
	}

	public Customer(long id, String firstName, String lastName, String emailAddress, String postCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.postCode = postCode;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailAddress, firstName, id, lastName, postCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(emailAddress, other.emailAddress) && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(postCode, other.postCode);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", postCode=" + postCode + "]";
	}

}
