package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.worksadvanced.project01.dto.MovementDto;
import com.bootcamp.worksadvanced.project01.mapper.IMovementMapper;
import com.bootcamp.worksadvanced.project01.repository.IMovementRepository;
import com.bootcamp.worksadvanced.project01.service.IMovementService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements IMovementService{

	@Autowired
	protected IMovementRepository _repository;
	
	@Autowired
	protected IMovementMapper _mapper;
	
	@Override
	public Mono<MovementDto> save(Mono<MovementDto> dto) {
		return dto.map(_mapper::dtoToEntity)
			.flatMap(_repository::save)
			.map(_mapper::entityToDto);
	}

	@Override
	public Mono<MovementDto> update(Mono<MovementDto> dto, String id) {
		return _repository.findById(id)
				.flatMap(m->dto.map(_mapper::dtoToEntity)
				.doOnNext(e->e.setId(id)))
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

	@Override
	public Flux<MovementDto> findAll() {
		return _repository.findAll().map(_mapper::entityToDto);
	}

	@Override
	public Mono<MovementDto> findById(String id) {
		return _repository.findById(id).map(_mapper::entityToDto);
	}

	@Override
	public Mono<Void> delete(String id) {
		return _repository.deleteById(id);
	}

}
