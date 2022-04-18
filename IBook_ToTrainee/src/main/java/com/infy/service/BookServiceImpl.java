package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BookDTO;
import com.infy.entity.Book;
import com.infy.exception.InfyBookException;
import com.infy.repository.BookRepository;
import com.infy.validator.Validator;

@Service(value="bookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDTO getBookDetails(Integer bookId) throws InfyBookException {
		Optional<Book> optional=bookRepository.findByBookId(bookId);
		Book book=optional.orElseThrow(() -> new InfyBookException("Service.BOOK_DETAILS_NOT_FOUND"));
		
		BookDTO b=new BookDTO();
		b.setAuthorName(book.getAuthorName());
		b.setBookId(book.getBookId());
		b.setIsbn(book.getIsbn());
		b.setPrice(book.getPrice());
		b.setPublishedYear(book.getPublishedYear());
		b.setPublisher(book.getPublisher());
		b.setTitle(book.getTitle());
		
		return b;
	}

	@Override
	public void addBook(BookDTO bookDTO) throws InfyBookException {
		//Validator.validate(bookDTO);
		//Optional<Book> optional=bookRepository.findById(bookDTO.getBookId());
		//optional.orElseThrow(() -> new InfyBookException("Service.BOOK_ALREADY_PRESENT"));
		bookRepository.addBook(bookDTO.getBookId(), bookDTO.getTitle(), bookDTO.getPublishedYear(), bookDTO.getPublisher(), bookDTO.getIsbn(), bookDTO.getPrice());
		
	}

	@Override
	public List<BookDTO> getBookByAuthorName(String authorName) throws InfyBookException {
		List<Book> list=bookRepository.findByAuthorName(authorName);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws InfyBookException {
		List<Book> list=bookRepository.findByPriceGreaterThanEqual(price);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookLessThanPrice(Integer price) throws InfyBookException {
		List<Book> list=bookRepository.findByPriceLessThanEqual(price);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws InfyBookException {
		List<Book> list=bookRepository.findByPublishedYearBetween(startYear, endYear);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws InfyBookException {
		List<Book> list=bookRepository.findByPublishedYearAfter(year);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws InfyBookException {
		List<Book> list=bookRepository.findByAuthorNameAndPublisher(authorName, publisher);
		if(list.isEmpty()) {
			throw new InfyBookException("Service.BOOK_NOT_FOUND");
		}
		List<BookDTO> result=new ArrayList<>();
		for(Book b:list) {
			BookDTO b1=new BookDTO();
			b1.setAuthorName(b.getAuthorName());
			b1.setBookId(b.getBookId());
			b1.setIsbn(b.getIsbn());
			b1.setPrice(b.getPrice());
			b1.setPublishedYear(b.getPublishedYear());
			b1.setPublisher(b.getPublisher());
			b1.setTitle(b.getTitle());
			result.add(b1);
		}
		return result;
	}

	@Override
	public void updateBookPrice(Integer bookId, Integer price) throws InfyBookException {
		Optional<Book> optional=bookRepository.findById(bookId);
		optional.orElseThrow(() -> new InfyBookException("Service.BOOK_NOT_FOUND"));
		bookRepository.updateBookPrice(price, bookId);
	}

	@Override
	public void deleteBook(Integer bookId) throws InfyBookException {
		Optional<Book> optional=bookRepository.findById(bookId);
		optional.orElseThrow(() -> new InfyBookException("Service.BOOK_NOT_FOUND"));
		bookRepository.deleteBook(bookId);
		
	}


	
}
