package com.library.services;

import com.library.modles.Book;

public interface BookService {

	public  Book createBook(String title, String author, int availableCopies);
	
	public Book getBookById(Integer bookId);
}
