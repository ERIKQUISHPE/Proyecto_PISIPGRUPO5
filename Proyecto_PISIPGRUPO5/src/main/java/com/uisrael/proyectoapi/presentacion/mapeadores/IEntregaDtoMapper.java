package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Entrega;
import com.uisrael.proyectoapi.presentacion.dto.request.EntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.EntregaResponseDTO;

@Mapper(componentModel = "spring")
public interface IEntregaDtoMapper {

	Entrega toDomain(EntregaRequestDTO dto);

	EntregaResponseDTO toResponseDto(Entrega entrega);
}

