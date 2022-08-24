package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerCreditsDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerCreditsService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customercredits")
@Slf4j
public class CustomerCreditsController {

	@Autowired
	protected ICustomerCreditsService _service;
	
	@GetMapping(value="/getall")
	public Flux<CustomerCreditsDto> getall() {
		log.info("Ingresando al método getall In: "+this.getClass().getName());
		return (Flux<CustomerCreditsDto>) _service.findAll();
	}
	
	@PostMapping(value = "/add")
	public Mono<CustomerCreditsDto> add(@RequestBody Mono<CustomerCreditsDto> dto){
		log.info("Ingresando al método guardar In:"+this.getClass().getName());
		return _service.save(dto);
	}
	@GetMapping(value="/get/{id}")
	public Mono<CustomerCreditsDto> get(@PathVariable String id){
		log.info("Ingresando al método get In : "+this.getClass().getName());
		return _service.findById(id);
	}
}
