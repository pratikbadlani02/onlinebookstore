package com.deloitte.onlinebookstore.controller;

import com.deloitte.onlinebookstore.model.Book;
import com.deloitte.onlinebookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "fetch list of all books", description = "accessible to users and admins")
    @GetMapping("/api/books")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Operation(summary = "fetch book details by id", description = "accessible to users and admins")
    @GetMapping("/api/book/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> getBooksById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Operation(summary = "add a new book to inventory", description = "accessible to admins")
    @PostMapping("/api/book")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @Operation(summary = "update existing book details by id", description = "accessible to admins")
    @PutMapping("/api/book/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                           @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @Operation(summary = "delete an existing book by id", description = "accessible to admins")
    @DeleteMapping("/api/book/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully.");
    }

    @Operation(summary = "search books by title or author or genre", description = "accessible to users and admins")
    @GetMapping("/api/book/search")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) String author,
                                                  @RequestParam(required = false) String genre) {
        return ResponseEntity.ok(bookService.searchBooks(title, author, genre));
    }

}
