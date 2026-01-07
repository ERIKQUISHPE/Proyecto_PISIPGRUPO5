package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EstadoOrdenJpa;

@Mapper (componentModel = "spring")
public interface IEstadoOrdenJpaMapper {
	
	EstadoOrden toDomain(EstadoOrdenJpa entity);
	
	EstadoOrdenJpa toEntity(EstadoOrden estadoOrden);
}
