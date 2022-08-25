package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.CustomerCreditsDto;
import com.bootcamp.worksadvanced.project01.service.ICustomerCreditsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customercredits")
@Slf4j
public class CustomerCreditsController extends ApiController<CustomerCreditsDto, String, ICustomerCreditsService>{

}
