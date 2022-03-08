package com.qa.springbootproject.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@Size(min = 2, max = 30)
	private String firstName;

	@Column(nullable = false)
	@Size(min = 2, max = 30)
	private String lastName;

	@Column(nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	private String emailAddress;

	@Column(nullable = false)
	@Pattern(regexp = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$")
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
