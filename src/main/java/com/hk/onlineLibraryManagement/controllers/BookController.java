package com.hk.onlineLibraryManagement.controllers;

import com.hk.onlineLibraryManagement.DTOs.CreateBookRequest;
import com.hk.onlineLibraryManagement.models.Book;
import com.hk.onlineLibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public Long createBook(@RequestBody CreateBookRequest createBookRequest) {
        return this.bookService.createBook(createBookRequest.toBook());
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable("id") Long bookId) {
        return this.bookService.getBookById(bookId);
    }

}
