package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.presentacion.dto.request.EquipoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EquipoResponseDTO;

@Mapper(componentModel = "spring")
public interface IEquipoDtoMapper {
	Equipo toDomain(EquipoRequestDTO dto);

	EquipoResponseDTO toResponseDto(Equipo equipo);

}
