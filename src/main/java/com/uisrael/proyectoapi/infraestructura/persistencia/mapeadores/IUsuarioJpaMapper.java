package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;

@Mapper (componentModel = "spring")
public interface IUsuarioJpaMapper {
	
	Usuario toDomain(UsuarioJpa entity);
	
	@Mapping(target = "creadoEn", ignore = true)
	UsuarioJpa toEntity(Usuario usuario);
}
