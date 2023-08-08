package com.rest.example.entity;

public class BookMdl {

	private int bookId;
	private String bookName;
	private String bookAuther;

	public BookMdl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookMdl(int bookId, String bookName, String bookAuther) {
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

	public String getBookAuther() {
		return bookAuther;
	}

	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}

	@Override
	public String toString() {
		return "BookMdl [bookId=" + bookId + ", bookName=" + bookName + ", bookAuther=" + bookAuther + "]";
	}

}
