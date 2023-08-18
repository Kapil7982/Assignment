package com.library.services;

import java.time.LocalDate;

import com.library.modles.Book;
import com.library.modles.Borrow;
import com.library.modles.User;

public interface BorrowService {

	Borrow borrowBook(Integer userId, Integer bookId);
	Borrow returnBook(Integer loanId);
}
