package com.bootcamp.worksadvanced.project01.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

	private String id;

	private String movementType;
	private double movementAmount;

	private String productId;
	private LocalDateTime movementDate;
}
