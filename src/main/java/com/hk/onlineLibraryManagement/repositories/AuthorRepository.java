package com.hk.onlineLibraryManagement.repositories;

import com.hk.onlineLibraryManagement.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByAuthorEmail(String authorEmail);
}
