package com.deloitte.onlinebookstore.repository;

import com.deloitte.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where title=?1 or author=?2 or genre=?3")
    List<Book> findByTitleorAuthororGenre(String title, String author, String genre);
}
