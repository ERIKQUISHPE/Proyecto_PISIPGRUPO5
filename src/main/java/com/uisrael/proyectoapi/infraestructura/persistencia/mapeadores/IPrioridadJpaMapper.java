package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Prioridad;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PrioridadJpa;

@Mapper (componentModel = "spring")
public interface IPrioridadJpaMapper {
	
	Prioridad toDomain(PrioridadJpa entity);
	
	PrioridadJpa toEntity(Prioridad prioridad);
}
