package com.library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.modles.Book;
import com.library.modles.Borrow;
import com.library.modles.User;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer>{

//	Optional<Borrow> findByUserAndBookAndReturned(User user, Book book, Boolean returned);
}
