package com.hk.onlineLibraryManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long authorId;

	private String authorName;

	@Column(unique=true)
	private String authorEmail;

	@CreationTimestamp
	private Date createdOn;

	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties("author")
	private List<Book> bookList;


}
