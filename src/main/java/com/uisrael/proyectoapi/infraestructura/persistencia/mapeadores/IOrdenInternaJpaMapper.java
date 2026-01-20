package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenInternaJpa;

@Mapper (componentModel = "spring")
public interface IOrdenInternaJpaMapper {
	
	OrdenInterna toDomain(OrdenInternaJpa entity);
	
	@Mapping(target = "creadoEn", ignore = true)
	OrdenInternaJpa toEntity(OrdenInterna ordenInterna);
}
