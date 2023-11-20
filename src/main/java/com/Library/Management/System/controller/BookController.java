package com.Library.Management.System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Library.Management.System.entity.Book;
import com.Library.Management.System.service.BookService;

@Controller
public class BookController {
	
	//injecting dependency book service
	private BookService bookService;

	/*as we are using constructor based dependency so lets create constructor
	if spring bean have only one constructor we can omit @Autowired annotation*/
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	/*handler method to handle list books and return model and view
	 inside model.addAtrribute("books",...) 
	 here "books" is just a name which you can use it in your view(means book.html ) to get the value 
	 with ${books}*/
	
	@GetMapping("/books")
	public String listBooks(Model model, @RequestParam(name = "userId", required = false) String userId) {
		model.addAttribute("books", bookService.getAllBooks());
		model.addAttribute("userId", userId);
		return "books";
	}
	
	@GetMapping("/books/new")
	public String createBookForm(Model model) {
		
		//now we create empty book object to hold book form data
		Book book=new Book();
		
		model.addAttribute("book",book);
		/*here "book" is just a name which you can use it in your view(means create_book.html ) to get the value 
	      with th:object="${book}"*/
		
		return "create_book"; //this is view name inside template
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book ) {
		//(@ModelAttribute("object") type entity) - annotation to directly bind form data(entity) to the object
		
		//now save this entity to database for that:-
		bookService.saveBook(book);
		return "redirect:/books"; //this will redirect to method listBooks()
	}
	

	
	@GetMapping("/books/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
        /*@PathVariable to get id inside this-> (/books/edit/{id}); that is in order to bind 
          this id to some java variable.
		 "book" is used inside edit_book.html at <form th:action="@{/books/{id} (id=${book.id})" it is
		  used to get id from here to edit html page*/
		model.addAttribute("book",bookService.getBookById(id));
		
		return "edit_book";
	}
	
	@PostMapping("/books/{id}")
	public String updateBookForm(@PathVariable Long id, @ModelAttribute("book") Book book, Model model ) {
		//get book from database
		Book existingBook=bookService.getBookById(id);
		existingBook.setBookCode(book.getBookCode());
		existingBook.setBookName(book.getBookName());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setDate(book.getDate());
		
		//save updated book object
		bookService.updateBook(existingBook);
		return "redirect:/books";//this will redirect to method listBooks()
	}

	
	
	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBookById(id);
		return "redirect:/books";
	}
	
	
}
/* basically spring boot will configure view resolver for thymeleaf automatically 
   whenever it find a thymeleaf dependency in pom.xml file. So, we don't have to 
   manually create a view resolver bean for thymeleaf.
   Spring boot by default search for all the thymeleaf template under template folder.
   So, we place all thymeleaf template under template folder */
