package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;
import com.uisrael.proyectoapi.presentacion.dto.response.EquipoResponseDTO;

@Mapper(componentModel = "spring", uses = { IOrdenDtoMapper.class })
public interface IEquipoDtoMapper {

  EquipoResponseDTO toResponseDto(Equipo equipo);

}
