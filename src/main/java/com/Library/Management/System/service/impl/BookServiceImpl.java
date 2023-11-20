package com.Library.Management.System.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Library.Management.System.entity.Book;
import com.Library.Management.System.repository.BookRepository;
import com.Library.Management.System.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	// to inject dependencies we use constructor base injection dependencies
	private BookRepository bookRepository;
	
	/* as we are using constructor base dependency injection so generate constructor here
	here we also avoid @Autowired annotation because this spring bean have only one constructor*/
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long bookCode) {
		// TODO Auto-generated method stub
		return bookRepository.findById(bookCode).get();
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteBookById(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}



}
