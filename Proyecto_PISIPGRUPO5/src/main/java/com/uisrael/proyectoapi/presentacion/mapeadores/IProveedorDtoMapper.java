package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Proveedor;
import com.uisrael.proyectoapi.presentacion.dto.request.ProveedorRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ProveedorResponseDTO;

@Mapper(componentModel = "spring")
public interface IProveedorDtoMapper {
	Proveedor toDomain(ProveedorRequestDTO dto);

	ProveedorResponseDTO toResponseDto(Proveedor proveedor);

}
