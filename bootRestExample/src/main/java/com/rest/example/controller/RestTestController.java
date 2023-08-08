package com.rest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * In this example we learn about- 
	 * The use of @Controller/@RequestMapping/@ResponseBody 
	 * The use of @GetMapping or @RestController 
	 * (This annotations will change response into json o/p automatically)
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
		bookmdl.setBookAuther("James");

//		return "This is the rest example...";
		return bookmdl;
	}
//--------------------------------------------------------------------------------//
	
	/*
	 * These 2 examples are showing that how to get data of book with and without parameters
	 */
	
	@GetMapping("/book")
	public List<BookMdl> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/book/{id}")
	public BookMdl getSingleBook(@PathVariable("id") int id) {
		return bookService.getSingleBook(id);
	}
	
	/*
	 * @PostMapping is used to add the data
	 */
	
	@PostMapping("/book")
	public BookMdl addBook(@RequestBody BookMdl bookMdl) {
		BookMdl addBook = this.bookService.addBook(bookMdl);
		return addBook;
	}
	
	/*
	 * @DeleteMapping is used to delete the data
	 */
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}
	
	/*
	 * @PutMapping is used to update the data
	 */
	
	@PutMapping("/book/{id}")
	public BookMdl updateBook(@RequestBody BookMdl bookMdl, @PathVariable("id") int id) {
		this.bookService.updateBook(bookMdl, id);
		return bookMdl;
	}

}
