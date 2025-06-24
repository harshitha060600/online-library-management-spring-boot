package com.hk.onlineLibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "author_table")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String authorEmail;
	
	private String authorName;
}
