package com.hk.onlineLibraryManagement.services;

import com.hk.onlineLibraryManagement.models.Author;
import com.hk.onlineLibraryManagement.models.Book;
import com.hk.onlineLibraryManagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;

    public Long createBook(Book book) {
        Author author = book.getAuthor();
        this.authorService.getOrCreate(author);
        book.setAuthor(author);
        return this.bookRepository.save(book).getBookID();
    }

    public Book getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(null);

    }

    public Book addOrUpdate(Book book) {
//        Book existingBook = this.getBookById(book.getId());
//        if (existingBook == null) {
        return bookRepository.save(book);
//        }
    }

}
