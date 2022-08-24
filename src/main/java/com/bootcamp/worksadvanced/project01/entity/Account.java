package com.bootcamp.worksadvanced.project01.entity;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
	@Id
	private String id;
	private short accountType;
	private short operationsLimit;
	private double maintenance;
	
	@DBRef
	private Collection<Movement> transactions;
}
