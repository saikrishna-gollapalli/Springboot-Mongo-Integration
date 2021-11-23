package com.sktech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sktech.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	public Book findByBookId(Integer bookId);
}
