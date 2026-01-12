package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.EstadoOrden;
import com.uisrael.proyectoapi.presentacion.dto.request.EstadoOrdenRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EstadoOrdenResponseDTO;

@Mapper(componentModel = "spring")
public interface IEstadoOrdenDtoMapper {
	EstadoOrden toDomain(EstadoOrdenRequestDTO dto);

	EstadoOrdenResponseDTO toResponseDto(EstadoOrden estadoOrden);

}
