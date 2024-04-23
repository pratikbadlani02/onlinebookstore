package com.deloitte.onlinebookstore.service;

import com.deloitte.onlinebookstore.model.Book;
import com.deloitte.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updateBook) {
         Book existingBook = getBookById(id);
         if (existingBook != null) {
             existingBook.setTitle(updateBook.getTitle());
             existingBook.setGenre(updateBook.getGenre());
             existingBook.setPrice(updateBook.getPrice());
             existingBook.setAuthor(updateBook.getAuthor());
             existingBook.setQuantity(updateBook.getQuantity());
             bookRepository.save(existingBook);
             return existingBook;
         }
         else
             return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title, String author, String genre) {
        return bookRepository.findByTitleorAuthororGenre(title, author, genre);
    }
}
