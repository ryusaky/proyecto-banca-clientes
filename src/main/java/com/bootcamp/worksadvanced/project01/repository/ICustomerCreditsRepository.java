package com.bootcamp.worksadvanced.project01.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.worksadvanced.project01.entity.CustomerCredits;

@Repository
public interface ICustomerCreditsRepository extends ReactiveMongoRepository<CustomerCredits, String>{

}
