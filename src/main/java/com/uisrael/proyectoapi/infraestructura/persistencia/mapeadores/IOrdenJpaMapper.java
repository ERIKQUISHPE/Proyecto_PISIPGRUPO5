package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;

@Mapper (componentModel = "spring")
public interface IOrdenJpaMapper {
	
	Orden toDomain(OrdenJpa entity);
	
	@Mapping(target = "fechaIngreso", ignore = true)
	@Mapping(target = "creadoEn", ignore = true)
	OrdenJpa toEntity(Orden orden);
}