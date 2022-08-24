package com.bootcamp.worksadvanced.project01.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<Dto, V> {

	Mono<Dto> save(Mono<Dto> dto);

	Mono<Dto> update(Mono<Dto> dto, V id);

	Flux<Dto> findAll();

	Mono<Dto> findById(V id);

	Mono<Void> delete(V id);
}
