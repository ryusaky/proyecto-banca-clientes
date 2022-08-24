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
@Document(collection = "customerAccounts")
public class CustomerAccounts {

	private String id;
	private String accountId;
	private String customerId;
	private double balance;
	private LocalDateTime creationDate;
	private String accountType;
}
