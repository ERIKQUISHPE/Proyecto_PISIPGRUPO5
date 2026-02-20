package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;

@Mapper (componentModel = "spring")
public interface IAccionReparacionJpaMapper {
	
	AccionReparacion toDomain(AccionReparacionJpa entity);
	
	@Mapping(target = "fechaAccion", ignore = true)
	AccionReparacionJpa toEntity(AccionReparacion accionReparacion);
}
