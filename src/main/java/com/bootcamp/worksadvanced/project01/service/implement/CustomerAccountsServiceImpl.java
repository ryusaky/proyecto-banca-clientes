package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerAccountsDto;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerAccountsMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerAccountsRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerAccountsService;
import com.bootcamp.worksadvanced.project01.util.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerAccountsServiceImpl implements ICustomerAccountsService{

	@Autowired
	protected ICustomerAccountsRepository _repository;
	
	@Autowired
	protected ICustomerAccountsMapper _mapper;
	
	@Override
	public Mono<CustomerAccountsDto> save(Mono<CustomerAccountsDto> dto) {
		return dto.map(_mapper::dtoToEntity)
				.doOnSuccess(e->e.setCreationDate(AppUtils.localDateTime()))
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerAccountsDto> update(Mono<CustomerAccountsDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m -> dto.map(_mapper::dtoToEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(_repository::save).map(_mapper::entityToDto);
	}

	@Override
	public Flux<CustomerAccountsDto> findAll() {
		return _repository.findAll().map(_mapper::entityToDto);
	}

	@Override
	public Mono<CustomerAccountsDto> findById(String id) {
		return _repository.findById(id).map(_mapper::entityToDto);
	}

	@Override
	public Mono<Void> delete(String id) {
		return _repository.deleteById(id);
	}

}
