package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EquipoJpa;

@Mapper (componentModel = "spring")
public interface IEquipoJpaMapper {
	
	Equipo toDomain(EquipoJpa entity);
	
	EquipoJpa toEntity(Equipo equipo);
}
