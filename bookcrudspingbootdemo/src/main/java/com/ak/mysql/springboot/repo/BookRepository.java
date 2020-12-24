package com.ak.mysql.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ak.mysql.springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	public List<Book> findBybookName(String bookName);
}
