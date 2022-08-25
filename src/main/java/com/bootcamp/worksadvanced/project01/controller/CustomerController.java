package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController extends ApiController<CustomerDto, String, ICustomerService>{
}
