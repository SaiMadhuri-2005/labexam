package com.KLEF.jfsd.repository;

import com.KLEF.jfsd.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
