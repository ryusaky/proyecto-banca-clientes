package com.bootcamp.worksadvanced.project01.entity;

import java.time.LocalDateTime;

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
@Document(collection = "movements")
public class Movement {

	@Id
	private String id;
	
	private String movementType;
	private double movementAmount;
	
	private String productId;
	private LocalDateTime movementDate;
	
}
