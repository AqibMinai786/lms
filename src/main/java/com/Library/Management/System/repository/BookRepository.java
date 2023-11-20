package com.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Library.Management.System.entity.Book;

// we don't need to add @Repository here because this jparepo have default implementation class SimpleJpaRepository and it is already annotated with @Repository
// This class have all the CRUD methods to interact with database
public interface BookRepository extends JpaRepository<Book, Long>{

}
