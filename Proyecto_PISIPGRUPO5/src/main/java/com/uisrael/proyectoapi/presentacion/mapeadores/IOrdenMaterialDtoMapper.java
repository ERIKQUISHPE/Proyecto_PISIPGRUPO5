package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenMaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenMaterialResponseDTO;

@Mapper(componentModel = "spring")
public interface IOrdenMaterialDtoMapper {
	OrdenMaterial toDomain(OrdenMaterialRequestDTO dto);

	OrdenMaterialResponseDTO toResponseDto(OrdenMaterial ordenMaterial);

}
