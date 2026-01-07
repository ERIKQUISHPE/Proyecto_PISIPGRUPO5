package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa;

@Mapper (componentModel = "spring")
public interface IMaterialJpaMapper {
	
	Material toDomain(MaterialJpa entity);
	
	MaterialJpa toEntity(Material material);
}
