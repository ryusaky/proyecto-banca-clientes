package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerDto;
import com.bootcamp.worksadvanced.project01.entity.Customer;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerService;

import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl 
extends SimpleServiceImpl<CustomerDto, Customer, String, ICustomerMapper, ICustomerRepository>
implements ICustomerService{


	@Override
	public Mono<CustomerDto> update(Mono<CustomerDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m -> dto.map(_mapper::dtoToEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(_repository::save).map(_mapper::entityToDto);
	}

}