package com.rest.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookMdl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String bookName;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author bookAuther;

	public BookMdl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookMdl(int bookId, String bookName, Author bookAuther) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuther = bookAuther;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(Author bookAuther) {
		this.bookAuther = bookAuther;
	}

	@Override
	public String toString() {
		return "BookMdl [bookId=" + bookId + ", bookName=" + bookName + ", bookAuther=" + bookAuther + "]";
	}

}
