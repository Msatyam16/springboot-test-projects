package com.rest.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.example.dao.BookRepo;
import com.rest.example.entity.BookMdl;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	// I have commented this because now i want to fetch data from the databses;

//	private static List<BookMdl> bookLst = new ArrayList<>();
//
//	static {
//		bookLst.add(new BookMdl(11, "Java book", "James"));
//		bookLst.add(new BookMdl(12, "Ramayan", "Ram"));
//		bookLst.add(new BookMdl(13, "Geeta", "Krishna"));
//		bookLst.add(new BookMdl(14, "satyam Book", "satyam"));
//		bookLst.add(new BookMdl(15, "Python Book", "Germany"));
//	}

	public List<BookMdl> getAllBooks() {

		// I have added this line to fecth data from db.
		List<BookMdl> bookLst = (List<BookMdl>) this.bookRepo.findAll();

		return bookLst;
	}

	public BookMdl getSingleBook(int id) {
		BookMdl bookMdl = null;

//		try {
//			bookMdl = bookLst.stream().filter(e -> e.getBookId() == id).findFirst().get();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

		bookMdl = this.bookRepo.findById(id);

		return bookMdl;
	}

	public BookMdl addBook(BookMdl b) {
//		bookLst.add(b);

		BookMdl saveResult = this.bookRepo.save(b);

		return saveResult;
	}

	public void deleteBook(int id) {
//		bookLst = bookLst.stream().filter(e -> e.getBookId() != id).collect(Collectors.toList());

		this.bookRepo.deleteById(id);
	}

	public void updateBook(BookMdl bookMdl, int id) {
//		bookLst = bookLst.stream().map(e -> {
//			if (e.getBookId() == id) {
//				e.setBookName(bookMdl.getBookName());
//				e.setBookAuther(bookMdl.getBookAuther());
//			}
//			return e;
//		}).collect(Collectors.toList());

		bookMdl.setBookId(id);
		this.bookRepo.save(bookMdl);
	}

}
