package com.sktech.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

	@Id
	private String id;
	@NonNull
	private Integer bookId;
	@NonNull
	private String bookName;
	@NonNull
	private String bookAuthor;
	@NonNull
	private Double bookCost;
}
