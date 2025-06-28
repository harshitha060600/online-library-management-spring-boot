package com.hk.onlineLibraryManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer studentID;
	
	private String studentName;

	@Column(unique=true, nullable=false)
	private String email;
	
	private String mobileNumber;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

//	Student:Book 1:M
//	Student:Transaction 1:M
	@OneToMany(mappedBy = "student")
	@JsonIgnoreProperties("student")
	private List<Book> issuedBooks;




	

}
