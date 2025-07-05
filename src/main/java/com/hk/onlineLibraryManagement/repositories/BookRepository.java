package com.hk.onlineLibraryManagement.repositories;

import com.hk.onlineLibraryManagement.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
