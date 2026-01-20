package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Entrega;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EntregaJpa;

@Mapper (componentModel = "spring")
public interface IEntregaJpaMapper {
	
	Entrega toDomain(EntregaJpa entity);
	
	@Mapping(target = "fechaEntrega", ignore = true)
	EntregaJpa toEntity(Entrega entrega);
}
