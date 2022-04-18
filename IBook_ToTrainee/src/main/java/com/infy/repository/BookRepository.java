package com.infy.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	Optional<Book> findByBookId(Integer bookId);
	
	
	@Query(value="insert into book (book_id,book_name,author_name,year,publisher,isbn,price) values (:bookId,:bookName,:authorName,:year,:publisher,:isbn,:price)",nativeQuery=true)
	@Modifying
	@Transactional
	void addBook(@Param("bookId") Integer bookId,@Param("bookName") String bookName,@Param("year") LocalDate year,@Param("publisher") String publisher,@Param("isbn") Long isbn,@Param("price") Integer price);
	
	List<Book> findByAuthorName(String authorName);
	
	List<Book> findByPriceGreaterThanEqual(Integer price);
	
	List<Book> findByPriceLessThanEqual(Integer price);
	
	List<Book> findByPublishedYearBetween(LocalDate startDate, LocalDate endDate);
	
	List<Book> findByPublishedYearAfter(LocalDate year);
	
	List<Book> findByAuthorNameAndPublisher(String authorName, String publisher);
	
	@Query("update Book b set b.price= :newPrice where b.bookId= :bookId ")
	@Modifying
	@Transactional
	Integer updateBookPrice(@Param("newPrice") Integer newPrice,@Param("bookId") Integer bookId);
	
	@Query("DELETE FROM Book b WHERE b.bookId = :bookId")
	@Modifying
	@Transactional
	Integer deleteBook(@Param("bookId") Integer bookId);
}
