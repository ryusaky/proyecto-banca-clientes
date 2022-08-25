package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerCreditsDto;
import com.bootcamp.worksadvanced.project01.entity.CustomerCredits;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerCreditsMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerCreditsRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerCreditsService;
import com.bootcamp.worksadvanced.project01.util.AppUtils;

import reactor.core.publisher.Mono;

@Service
public class CustomerCreditsServiceImpl 
extends SimpleServiceImpl<CustomerCreditsDto, CustomerCredits, String, ICustomerCreditsMapper, ICustomerCreditsRepository>
implements ICustomerCreditsService{
	
	@Override
	public Mono<CustomerCreditsDto> save(Mono<CustomerCreditsDto> dto) {
		return dto.map(_mapper::dtoToEntity)
				.doOnSuccess(e->e.setCreationDate(AppUtils.localDateTime()))
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
}
