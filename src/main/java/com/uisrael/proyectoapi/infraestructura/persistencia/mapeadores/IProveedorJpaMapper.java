package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProveedorJpa;

@Mapper (componentModel = "spring")
public interface IProveedorJpaMapper {
	
	Proveedor toDomain(ProveedorJpa entity);
	
	ProveedorJpa toEntity(Proveedor proveedor);
}
