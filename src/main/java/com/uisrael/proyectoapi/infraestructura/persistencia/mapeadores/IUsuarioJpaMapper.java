package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;

@Mapper (componentModel = "spring")
public interface IUsuarioJpaMapper {
	
	Usuario toDomain(UsuarioJpa entity);
	
	UsuarioJpa toEntity(Usuario usuario);
}
