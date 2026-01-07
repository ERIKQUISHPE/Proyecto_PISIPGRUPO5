package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;

@Mapper (componentModel = "spring")
public interface IOrdenJpaMapper {
	
	Orden toDomain(OrdenJpa entity);
	
	OrdenJpa toEntity(Orden orden);
}