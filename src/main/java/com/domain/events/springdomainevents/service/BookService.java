package com.domain.events.springdomainevents.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.domain.events.springdomainevents.domain.Book;
import com.domain.events.springdomainevents.repository.BookRepository;

@Service
public record BookService(BookRepository bookRepository) {

	public Book findBookById(Long id) {
		Optional<Book> found = bookRepository.findById(id);
		if (found.isEmpty()) {
			throw new EntityNotFoundException("Book not found by id " + id);
		}
		found.get().getAuthor();
		return found.get();
	}

	public Book addBook(Book book) {
		book.register();
		bookRepository.saveAndFlush(book);
		return book;
	}


	public Book updateBook(Long id, String name, String description) {
		Book book = findBookById(id);
		book.changeInfo(name, description);
		
		return bookRepository.save(book);
	}

}
