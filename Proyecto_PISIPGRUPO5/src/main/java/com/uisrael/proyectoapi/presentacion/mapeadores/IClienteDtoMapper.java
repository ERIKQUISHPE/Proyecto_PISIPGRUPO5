package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.presentacion.dto.request.ClienteRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ClienteResponseDTO;

@Mapper(componentModel = "spring")
public interface IClienteDtoMapper {
	
	Cliente toDomain(ClienteRequestDTO dto);
	
	ClienteResponseDTO toResponseDto(Cliente cliente);
}
