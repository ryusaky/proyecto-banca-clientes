package com.bootcamp.worksadvanced.project01.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {

	@Id
	private String id;
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String documentType;
	private String documentNumber;
	private String businessName;
	
}
