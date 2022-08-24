package com.bootcamp.worksadvanced.project01.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.worksadvanced.project01.entity.Movement;

@Repository
public interface IMovementRepository extends ReactiveMongoRepository<Movement, String>{

}
