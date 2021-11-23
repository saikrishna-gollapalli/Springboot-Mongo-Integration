package com.sktech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sktech.entity.Book;
import com.sktech.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping(value="/book")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return new ResponseEntity<String>("Book saved successfully!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<Book>> books() {
		List<Book> books = bookRepository.findAll();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping(value = "/book/{bookId}")
	public ResponseEntity<Book> bookById(@PathVariable Integer bookId) {
		Book book = bookRepository.findByBookId(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<String> bookById(@PathVariable String id) {
		bookRepository.deleteById(id);
		return new ResponseEntity<String>("Book deleted successfully", HttpStatus.OK);
	}
}
