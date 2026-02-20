package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Accesorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccesorioJpa;

@Mapper (componentModel = "spring")
public interface IAccesorioJpaMapper {
	
	Accesorio toDomain(AccesorioJpa entity);
	
	AccesorioJpa toEntity(Accesorio accesorio);
}
