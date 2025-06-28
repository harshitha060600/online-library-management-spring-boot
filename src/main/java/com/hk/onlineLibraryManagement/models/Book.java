package com.hk.onlineLibraryManagement.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookID;
	
	@Column
	private String bookName;

	@Enumerated(EnumType.STRING) // EnumType.ORDINAL is not recommended because it stores emun constants as numbers and later if we change the order of enum constants then data becomes in correct
	private Genre genre;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties("bookList")
//	@JsonIgnore
	private Author author;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties("issuedBooks")
	private Student student;
	
	
	
}
