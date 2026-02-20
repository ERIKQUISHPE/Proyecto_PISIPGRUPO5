package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Material;
import com.uisrael.proyectoapi.presentacion.dto.request.MaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.MaterialResponseDTO;

@Mapper(componentModel = "spring")
public interface IMaterialDtoMapper {
	
	Material toDomain(MaterialRequestDTO dto);

	MaterialResponseDTO toResponseDto(Material material);

}
