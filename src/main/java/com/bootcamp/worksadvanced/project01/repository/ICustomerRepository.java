package com.bootcamp.worksadvanced.project01.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.worksadvanced.project01.entity.Customer;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String>{
}
