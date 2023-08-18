package com.library.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.library.modles.Borrow;
import com.library.services.BorrowService;

@RestController
@RequestMapping("/library")
public class BorrowController {

	@Autowired
    private BorrowService borrowService;

	@PostMapping("/borrow")
    public ResponseEntity<Borrow> borrowBook(@RequestParam Integer userId, @RequestParam Integer bookId) {
        Borrow loan = borrowService.borrowBook(userId, bookId);
        return ResponseEntity.ok(loan);
    }

    @PostMapping("/return")
    public ResponseEntity<Borrow> returnBook(@RequestParam Integer loanId) {
    	Borrow loan = borrowService.returnBook(loanId);
        return ResponseEntity.ok(loan);
    }
}
