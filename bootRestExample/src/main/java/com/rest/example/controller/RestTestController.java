package com.rest.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.example.entity.BookMdl;
import com.rest.example.service.BookService;

//@Controller
@RestController
public class RestTestController {

	@Autowired
	private BookService bookService;

	/*
	 * In this example we learn about- The use
	 * of @Controller/@RequestMapping/@ResponseBody The use of @GetMapping
	 * or @RestController (This annotations will change response into json o/p
	 * automatically)
	 * 
	 */

//--------------------------------------------------------------------------------//
//	@RequestMapping(value = "/restTest", method = RequestMethod.GET)
//	@ResponseBody
	@GetMapping("/getBook")
	public BookMdl restTest() {

		BookMdl bookmdl = new BookMdl();
		bookmdl.setBookId(11);
		bookmdl.setBookName("Java book");
//		bookmdl.setBookAuther("James"); 

//		return "This is the rest example...";
		return bookmdl;
	}
//--------------------------------------------------------------------------------//

	/*
	 * These 2 examples are showing that how to get data of book with and without
	 * parameters
	 */

	@GetMapping("/book")
	public ResponseEntity<List<BookMdl>> getAllBooks() {
		List<BookMdl> book = bookService.getAllBooks();
		if (book.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<BookMdl> getSingleBook(@PathVariable("id") int id) {
		BookMdl book = bookService.getSingleBook(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	/*
	 * @PostMapping is used to add the data
	 */

	@PostMapping("/book")
	public ResponseEntity<BookMdl> addBook(@RequestBody BookMdl bookMdl) {
		BookMdl addBook = null;
		try {
			addBook = this.bookService.addBook(bookMdl);
			return ResponseEntity.of(Optional.of(addBook));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/*
	 * @DeleteMapping is used to delete the data
	 */

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	/*
	 * @PutMapping is used to update the data
	 */

	@PutMapping("/book/{id}")
	public ResponseEntity<BookMdl> updateBook(@RequestBody BookMdl bookMdl, @PathVariable("id") int id) {
		try {
			this.bookService.updateBook(bookMdl, id);
			return ResponseEntity.of(Optional.of(bookMdl));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
