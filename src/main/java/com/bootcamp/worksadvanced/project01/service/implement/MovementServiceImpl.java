package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.MovementDto;
import com.bootcamp.worksadvanced.project01.entity.Movement;
import com.bootcamp.worksadvanced.project01.mapper.IMovementMapper;
import com.bootcamp.worksadvanced.project01.repository.IMovementRepository;
import com.bootcamp.worksadvanced.project01.service.IMovementService;

import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl extends SimpleServiceImpl<MovementDto, Movement, String, IMovementMapper, IMovementRepository> 
implements IMovementService{

	@Override
	public Mono<MovementDto> update(Mono<MovementDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m->dto.map(_mapper::dtoToEntity)
				.doOnNext(e->e.setId(id)))
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

}
