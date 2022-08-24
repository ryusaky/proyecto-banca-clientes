package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerAccountsDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerAccountsService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customeraccounts")
@Slf4j
public class CustomerAccountsController {

	@Autowired
	protected ICustomerAccountsService _service;
	
	
	@GetMapping(value="/getall")
	public Flux<CustomerAccountsDto> getall() {
		log.info("Ingresando al método getall In: "+this.getClass().getName());
		return (Flux<CustomerAccountsDto>) _service.findAll();
	}
	
	@PostMapping(value = "/add")
	public Mono<CustomerAccountsDto> add(@RequestBody Mono<CustomerAccountsDto> dto){
		log.info("Ingresando al método guardar In:"+this.getClass().getName());
		return _service.save(dto);
	}
	
	@GetMapping(value="/get/{id}")
	public Mono<CustomerAccountsDto> get(@PathVariable String id){
		log.info("Ingresando al método get In : "+this.getClass().getName());
		return _service.findById(id);
	}
}
