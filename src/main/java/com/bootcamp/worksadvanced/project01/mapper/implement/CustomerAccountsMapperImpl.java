package com.bootcamp.worksadvanced.project01.mapper.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bootcamp.worksadvanced.project01.dto.CustomerAccountsDto;
import com.bootcamp.worksadvanced.project01.entity.CustomerAccounts;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerAccountsMapper;

@Component
public class CustomerAccountsMapperImpl implements ICustomerAccountsMapper{

	@Override
	public CustomerAccountsDto entityToDto(CustomerAccounts entity) {
		CustomerAccountsDto dto = CustomerAccountsDto.builder().build();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public CustomerAccounts dtoToEntity(CustomerAccountsDto dto) {
		CustomerAccounts entity = CustomerAccounts.builder().build();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
