package com.rest.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authId;
	private String firstName;
	private String lastName;

	@OneToOne(mappedBy = "bookAuther")
	@JsonBackReference
	private BookMdl book;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authId, String firstName, String lastName, BookMdl book) {
		super();
		this.authId = authId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.book = book;
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

	public BookMdl getBook() {
		return book;
	}

	public void setBook(BookMdl book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Author [authId=" + authId + ", firstName=" + firstName + ", lastName=" + lastName + ", book=" + book
				+ "]";
	}

}
