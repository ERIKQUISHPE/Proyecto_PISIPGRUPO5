package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;	

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.presentacion.dto.request.AccionReparacionRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionResponseDTO;

@Mapper(componentModel = "spring")
public interface IAccionReparacionDtoMapper {
	AccionReparacion toDomain(AccionReparacionRequestDTO dto);

	AccionReparacionResponseDTO toResponseDto(AccionReparacion accionReparacion);

}
