package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenInternaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenInternaResponseDTO;

@Mapper(componentModel = "spring")
public interface IOrdenInternaDtoMapper {
	OrdenInterna toDomain(OrdenInternaRequestDTO dto);

	OrdenInternaResponseDTO toResponseDto(OrdenInterna ordenInterna);

}
