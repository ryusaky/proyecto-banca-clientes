package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerAccountsDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerAccountsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customeraccounts")
@Slf4j
public class CustomerAccountsController extends ApiController<CustomerAccountsDto, String, ICustomerAccountsService> {

}
