package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.modles.Book;
import com.library.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(String title, String author, int availableCopies) {
		
		Book book = new Book();
		
		book.setTitle(title);
		book.setAuthor(author);
	    book.setAvailableCopies(availableCopies);
	    
	    return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Integer bookId) {
		
		return bookRepository.findById(bookId).orElse(null);
	}
	
	
}
