package com.library.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.library.component.FineCalculator;
import com.library.modles.Book;
import com.library.modles.Borrow;
import com.library.modles.User;
import com.library.repositories.BookRepository;
import com.library.repositories.BorrowRepository;
import com.library.repositories.UserRepository;

@Service
public class BorrowServiceImpl implements BorrowService{
	
	@Autowired
	private BorrowRepository borrowRepository;
	
	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

   

    public Borrow borrowBook(Integer userId, Integer bookId) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        LocalDate dueDate = LocalDate.now().plusDays(14);

        Borrow loan = new Borrow();
        loan.setUser(user);
        loan.setBook(book);
        loan.setDueDate(dueDate);

        return borrowRepository.save(loan);
    }

	@Override
	public Borrow returnBook(Integer loanId) {
		
		Borrow loan = borrowRepository.findById(loanId).orElseThrow();
        LocalDate returnDate = LocalDate.now();

        loan.setReturnDate(returnDate);

        if (returnDate.isAfter(loan.getDueDate())) {
            double fineAmount = FineCalculator.calculateFine(loan.getDueDate(), returnDate);
            loan.setFineAmount(fineAmount);
        }

        return borrowRepository.save(loan);
	}

	
    
	

	

    

	

	

}
