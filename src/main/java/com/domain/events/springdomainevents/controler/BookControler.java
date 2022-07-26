package com.domain.events.springdomainevents.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.events.springdomainevents.domain.Book;
import com.domain.events.springdomainevents.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public record BookControler(BookService bookService) {

	@GetMapping("/{id}")
	public Book findBookById(@PathVariable Long id) {
		return bookService.findBookById(id);
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PatchMapping("/{id}")
	public Book updateBook(
			@PathVariable Long id,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "description", required = true) String description) {
		return bookService.updateBook(id, name, description);
	}
}
