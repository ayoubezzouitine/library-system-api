package com.example.librarybookmanagementsystem.repository;

import com.example.librarybookmanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
