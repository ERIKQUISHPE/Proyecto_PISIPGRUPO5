package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Accesorio;
import com.uisrael.proyectoapi.presentacion.dto.request.AccesorioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccesorioResponseDTO;

@Mapper(componentModel = "spring")
public interface IAccesorioDtoMapper {
	Accesorio toDomain(AccesorioRequestDTO dto);

	AccesorioResponseDTO toResponseDto(Accesorio accesorio);
}
