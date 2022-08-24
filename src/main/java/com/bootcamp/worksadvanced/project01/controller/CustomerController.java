package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerService;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	protected ICustomerService _service;
	
	
	@GetMapping
	public Flux<CustomerDto> getall() {
		return (Flux<CustomerDto>) _service.findAll();
	}
}
