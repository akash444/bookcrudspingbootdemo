package com.ak.mysql.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.mysql.springboot.model.Book;
import com.ak.mysql.springboot.repo.BookRepository;

@RestController
public class BookController {
	@Autowired
	BookRepository bookRepo;
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepo.save(book);
		System.out.println("OK");
		return "Your Record Is Saved Successfully!";
	}
	
	@PostMapping("/multipleBookSave")
	public String multipleBookSave(@RequestBody List<Book> book) {
		bookRepo.saveAll(book);
		return "Your List of Record Is Saved Successfully!";
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		List<Book> bookList = bookRepo.findAll();
		return bookList;
	}
	
	@GetMapping("/getBookByName/{bookName}")
	public List<Book> getBookByName(@PathVariable("bookName") String bookName) {
		return bookRepo.findBybookName(bookName);
	}
	
	@GetMapping("/getBookById/{bookID}")
	public Optional<Book> getBookById(@PathVariable("bookID") Long bookID) {
		return bookRepo.findById(bookID);
	}
	
	@DeleteMapping("/deleteByBookId/{bookID}")
	public String deleteByBookId(@PathVariable("bookID") Long bookID) {
		String response = "";
		try {
			bookRepo.deleteById(bookID);
			response = "SUCCESSFULLY DELETED!";
			
		}catch(Exception e) {
			response = "UNABLE TO DELETE!";
		}
		
		return response;
	}
}
