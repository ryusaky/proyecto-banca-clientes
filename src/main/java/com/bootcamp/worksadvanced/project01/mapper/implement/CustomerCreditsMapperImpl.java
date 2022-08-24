package com.bootcamp.worksadvanced.project01.mapper.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bootcamp.worksadvanced.project01.dto.CustomerCreditsDto;
import com.bootcamp.worksadvanced.project01.entity.CustomerCredits;
import com.bootcamp.worksadvanced.project01.mapper.ICustomerCreditsMapper;

@Component
public class CustomerCreditsMapperImpl implements ICustomerCreditsMapper{

	@Override
	public CustomerCreditsDto entityToDto(CustomerCredits entity) {
		CustomerCreditsDto dto = CustomerCreditsDto.builder().build();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public CustomerCredits dtoToEntity(CustomerCreditsDto dto) {
		CustomerCredits entity = CustomerCredits.builder().build();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
