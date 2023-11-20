package com.Library.Management.System.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookCode;
	
	@Column(name = "bookName", nullable=false)
	private String bookName;
	
	@Column(name = "author")
	private String author;	
	
	@Column(name = "date")
	private String date;
	
	
	public Book() {
		
	}
	public Book(String bookName, String author, String date) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.date = date;
	}
	public Long getBookCode() {
		return bookCode;
	}
	public void setBookCode(Long bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}