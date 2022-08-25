package com.bootcamp.worksadvanced.project01.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.worksadvanced.project01.mapper.IMapperObject;
import com.bootcamp.worksadvanced.project01.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class SimpleServiceImpl<Dto,E,V,
	M extends IMapperObject<E, Dto>,
	I extends ReactiveMongoRepository<E,V>> implements ICRUD<Dto, V>{
	
	@Autowired
	protected M _mapper;
	
	@Autowired
	protected I _repository;
	
	@Override
	public Mono<Dto> save(Mono<Dto> dto) {
		return dto.map(_mapper::dtoToEntity)
				.flatMap(_repository::save)
				.map(_mapper::entityToDto);
	}

	@Override
	public Mono<Dto> update(Mono<Dto> dto, V id) {
		return _repository.findById(id)
				.flatMap(m -> dto.map(_mapper::dtoToEntity))
				.flatMap(_repository::save).map(_mapper::entityToDto);
	}

	@Override
	public Flux<Dto> findAll() {
		return _repository.findAll().map(_mapper::entityToDto);
	}

	@Override
	public Mono<Dto> findById(V id) {
		return _repository.findById(id).map(_mapper::entityToDto);
	}

	@Override
	public Mono<Void> delete(V id) {
		return _repository.deleteById(id);
	}
	
}
