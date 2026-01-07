package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenInternaJpa;

@Mapper (componentModel = "spring")
public interface IOrdenInternaJpaMapper {
	
	OrdenInterna toDomain(OrdenInternaJpa entity);
	
	OrdenInternaJpa toEntity(OrdenInterna ordenInterna);
}
