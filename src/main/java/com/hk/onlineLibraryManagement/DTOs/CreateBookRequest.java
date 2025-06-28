package com.hk.onlineLibraryManagement.DTOs;

import com.hk.onlineLibraryManagement.models.Author;
import com.hk.onlineLibraryManagement.models.Book;
import com.hk.onlineLibraryManagement.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {

    private String bookName;

    private Genre genre;

    private String authorName;

    private String authorEmail;

    public Book toBook(){
        return Book.builder()
                .bookName(bookName)
                .genre(genre)
                .author(Author.builder()
                        .authorName(authorName)
                        .authorEmail(authorEmail)
                        .build())
                .build();
    }

}
