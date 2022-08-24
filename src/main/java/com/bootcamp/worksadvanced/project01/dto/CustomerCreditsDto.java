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
public class CustomerCreditsDto {

	private String id;
	private String creditId;
	private String customerId;
	
	private double creditLine;
	private double usedLine;
	private LocalDateTime creationDate;
}
