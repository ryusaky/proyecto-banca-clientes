package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.CustomerAccountsDto;
import com.bootcamp.worksadvanced.project01.entity.CustomerAccounts;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerAccountsMapper;
import com.bootcamp.worksadvanced.project01.repository.ICustomerAccountsRepository;
import com.bootcamp.worksadvanced.project01.service.ICustomerAccountsService;
import com.bootcamp.worksadvanced.project01.util.AppUtils;

import reactor.core.publisher.Mono;

@Service
public class CustomerAccountsServiceImpl
extends SimpleServiceImpl<CustomerAccountsDto, CustomerAccounts, String, ICustomerAccountsMapper, ICustomerAccountsRepository>
implements ICustomerAccountsService{

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
}
