package com.bootcamp.worksadvanced.project01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.worksadvanced.project01.dto.MovementDto;
import com.bootcamp.worksadvanced.project01.service.IMovementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movements")
@Slf4j
public class MovementController extends ApiController<MovementDto, String, IMovementService>{
    
}
