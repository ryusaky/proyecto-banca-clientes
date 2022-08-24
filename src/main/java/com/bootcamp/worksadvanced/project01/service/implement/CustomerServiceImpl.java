package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerDto;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	protected ICustomerRepository _repository;
	
	@Autowired
	protected ICustomerMapper _mapper;
	
	@Override
	public Mono<CustomerDto> save(Mono<CustomerDto> dto) {
		
		return dto.map(_mapper::dtoToEntity)
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerDto> update(Mono<CustomerDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m -> dto.map(_mapper::dtoToEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(_repository::save).map(_mapper::entityToDto);
	}

	@Override
	public Flux<CustomerDto> findAll() {
		return _repository.findAll().map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerDto> findById(String id) {
		return _repository.findById(id).map(_mapper::entityToDto);
	}

	@Override
	public Mono<Void> delete(String id) {
		return _repository.deleteById(id);
	}

}
