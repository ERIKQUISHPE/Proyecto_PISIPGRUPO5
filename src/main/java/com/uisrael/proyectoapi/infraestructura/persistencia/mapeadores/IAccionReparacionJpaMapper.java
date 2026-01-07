package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;

@Mapper (componentModel = "spring")
public interface IAccionReparacionJpaMapper {
	
	AccionReparacion toDomain(AccionReparacionJpa entity);
	
	AccionReparacionJpa toEntity(AccionReparacion accionReparacion);
}
