package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Prioridad;
import com.uisrael.proyectoapi.presentacion.dto.request.PrioridadRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PrioridadResponseDTO;

@Mapper(componentModel = "spring")
public interface IPrioridadDtoMapper {
	Prioridad toDomain(PrioridadRequestDTO dto);

	PrioridadResponseDTO toResponseDto(Prioridad prioridad);

}
