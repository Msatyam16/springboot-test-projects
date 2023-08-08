package com.rest.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.example.entity.BookMdl;

@Service
public class BookService {

	private static List<BookMdl> bookLst = new ArrayList<>();

	static {
		bookLst.add(new BookMdl(11, "Java book", "James"));
		bookLst.add(new BookMdl(108, "Ramayan", "Ram"));
		bookLst.add(new BookMdl(1121, "Geeta", "Krishna"));
	}

	public List<BookMdl> getAllBooks() {
		return bookLst;
	}

	public BookMdl getSingleBook(int id) {

		BookMdl bookMdl = bookLst.stream().filter(e -> e.getBookId() == id).findFirst().get();

		return bookMdl;
	}

}
