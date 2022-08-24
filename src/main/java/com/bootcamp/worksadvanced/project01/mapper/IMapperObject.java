package com.bootcamp.worksadvanced.project01.mapper;

public interface IMapperObject <E, Dto>{

	public Dto entityToDto(E entity);
	public  E dtoToEntity(Dto dto);
}