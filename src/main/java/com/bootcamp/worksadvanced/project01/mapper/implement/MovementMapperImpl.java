package com.bootcamp.worksadvanced.project01.mapper.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bootcamp.worksadvanced.project01.dto.MovementDto;
import com.bootcamp.worksadvanced.project01.entity.Movement;
import com.bootcamp.worksadvanced.project01.mapper.IMovementMapper;

@Component
public class MovementMapperImpl implements IMovementMapper{

	@Override
	public MovementDto entityToDto(Movement entity) {
		MovementDto dto = MovementDto.builder().build();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	@Override
	public Movement dtoToEntity(MovementDto dto) {
		Movement entity = Movement.builder().build();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
