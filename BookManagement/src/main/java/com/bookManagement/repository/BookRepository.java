package com.bookManagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookManagement.model.Book;


@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

	List<Book> findByTitleContainingOrAuthorContainingOrGenreContaining(String title, String author, String genre);
}
