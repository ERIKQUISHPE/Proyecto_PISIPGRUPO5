package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenMaterialJpa;

@Mapper (componentModel = "spring")
public interface IOrdenMaterialJpaMapper {
	
	OrdenMaterial toDomain(OrdenMaterialJpa entity);
	
	OrdenMaterialJpa toEntity(OrdenMaterial ordenMaterial);
}
