package com.bootcamp.worksadvanced.project01.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountsDto {
	private String id;
	private String accountId;
	private String customerId;
	private double balance;
	private LocalDateTime creationDate;
	private String accountType;
}
