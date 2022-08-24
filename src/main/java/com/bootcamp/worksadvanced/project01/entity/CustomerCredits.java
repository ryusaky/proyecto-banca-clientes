package com.bootcamp.worksadvanced.project01.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerCredits")
public class CustomerCredits {
	
	private String id;
	private String creditId;
	private String customerId;
	
	private double creditLine;
	private double usedLine;
	private LocalDateTime creationDate;
}
