package com.example.librarybookmanagementsystem.controller;

import com.example.librarybookmanagementsystem.model.Book;
import com.example.librarybookmanagementsystem.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    // no need to make @Autowired because spring container is smart enough
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book, @RequestParam Long categoryId) {
        Book createdBook = bookService.createBook(book, categoryId);
        return ResponseEntity.status(201).body(createdBook);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(()-> new RuntimeException("The book that you are looking is not found under the id " + id));
        return ResponseEntity.ok(book);
    }

    @PutMapping("{id}/{idCategory}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book, @PathVariable Long idCategory) {
        Book updateBook = bookService.updateBook(id, book, idCategory);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
