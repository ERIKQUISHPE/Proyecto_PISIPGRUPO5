package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {
	Usuario toDomain(UsuarioRequestDTO dto);

	UsuarioResponseDTO toResponseDto(Usuario usuario);
}
 