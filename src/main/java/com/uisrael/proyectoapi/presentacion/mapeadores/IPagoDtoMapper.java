package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.presentacion.dto.request.PagoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PagoResponseDTO;

@Mapper(componentModel = "spring")
public interface IPagoDtoMapper {
	Pago toDomain(PagoRequestDTO dto);

	PagoResponseDTO toResponseDto(Pago pago);

}
