package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bootcamp.worksadvanced.project01.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class ApiController<Dto,V,I extends ICRUD<Dto, V>> {
	
	@Autowired
	protected I _service;
	
	@GetMapping(value="/getall")
	public Flux<Dto> getall(){
		return (Flux<Dto>) _service.findAll();
	}
	
	@PostMapping(value = "/add")
	public Mono<Dto> add(@RequestBody Mono<Dto> dto){
		return _service.save(dto);
	}
	
	@GetMapping(value="/get/{id}")
	public Mono<Dto> get(@PathVariable V id){
		return _service.findById(id);
	}

}
