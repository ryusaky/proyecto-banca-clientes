package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	protected ICustomerService _service;
	
	
	@GetMapping
	public Flux<CustomerDto> getall() {
		log.info("Ingresando al método getall In: "+this.getClass().getName());
		return (Flux<CustomerDto>) _service.findAll();
	}
	
	@PostMapping(value = "/add")
	public Mono<CustomerDto> add(@RequestBody Mono<CustomerDto> dto){
		log.info("Ingresando al método guardar In:"+this.getClass().getName());
		return _service.save(dto);
	}
	
	@GetMapping(value="/get/{id}")
	public Mono<CustomerDto> get(@PathVariable String id){
		log.info("Ingresando al método get In : "+this.getClass().getName());
		return _service.findById(id);
	}
}
