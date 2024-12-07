package com.KLEF.jfsd.exam.service;

import com.KLEF.jfsd.model.Book;
import com.KLEF.jfsd.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setPrice(updatedBook.getPrice());
            book.setPublishedYear(updatedBook.getPublishedYear());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
}

