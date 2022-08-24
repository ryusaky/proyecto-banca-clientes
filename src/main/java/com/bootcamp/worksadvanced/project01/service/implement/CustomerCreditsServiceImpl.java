package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerCreditsDto;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerCreditsMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerCreditsRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerCreditsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerCreditsServiceImpl implements ICustomerCreditsService{

	@Autowired
	protected ICustomerCreditsRepository _repository;
	
	@Autowired
	protected ICustomerCreditsMapper _mapper;
	
	@Override
	public Mono<CustomerCreditsDto> save(Mono<CustomerCreditsDto> dto) {
		
		return dto.map(_mapper::dtoToEntity)
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerCreditsDto> update(Mono<CustomerCreditsDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m -> dto.map(_mapper::dtoToEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(_repository::save).map(_mapper::entityToDto);
	}

	@Override
	public Flux<CustomerCreditsDto> findAll() {
		return _repository.findAll().map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerCreditsDto> findById(String id) {
		return _repository.findById(id).map(_mapper::entityToDto);
	}

	@Override
	public Mono<Void> delete(String id) {
		return _repository.deleteById(id);
	}

}
