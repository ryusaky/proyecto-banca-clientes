package com.bootcamp.worksadvanced.project01.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private String id;
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String documentType;
	private String documentNumber;
	private String businessName;
}
