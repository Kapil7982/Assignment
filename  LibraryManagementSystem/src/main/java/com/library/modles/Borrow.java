package com.library.modles;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Borrow {


	@Id
	private Integer borrowId;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Book book;
	
	private LocalDate dueDate;
	
	private LocalDate returnDate;
	
	private double FineAmount;
	
}
