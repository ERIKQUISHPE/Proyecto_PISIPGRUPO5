package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;
import com.uisrael.proyectoapi.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

  @Mapping(target = "passwordHash", source = "password")
  Usuario toDomain(UsuarioRequestDTO dto);

  UsuarioResponseDTO toResponseDto(Usuario usuario);

  UsuarioJpa toEntity(Usuario usuario);
}
