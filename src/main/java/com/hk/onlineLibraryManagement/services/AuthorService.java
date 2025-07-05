package com.hk.onlineLibraryManagement.services;

import com.hk.onlineLibraryManagement.models.Author;
import com.hk.onlineLibraryManagement.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getOrCreate(Author author) {
        Author existingAuthor = this.authorRepository.findByAuthorEmail(author.getAuthorEmail());

        if(existingAuthor == null){
            author = this.authorRepository.save(author);
            return author;
        }
        return existingAuthor;
    }
}
