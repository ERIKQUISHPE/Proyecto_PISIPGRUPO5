package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;


import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenResponseDTO;

@Mapper(componentModel = "spring")
public interface IOrdenDtoMapper {
	
	Orden toDomain(OrdenRequestDTO dto);
	
	OrdenResponseDTO toResponseDto(Orden orden);
}
