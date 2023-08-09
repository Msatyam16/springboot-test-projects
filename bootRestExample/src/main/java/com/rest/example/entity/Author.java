package com.rest.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authId;
	private String firstName;
	private String lastName;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authId, String firstName, String lastName) {
		super();
		this.authId = authId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
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

	@Override
	public String toString() {
		return "Author [authId=" + authId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
