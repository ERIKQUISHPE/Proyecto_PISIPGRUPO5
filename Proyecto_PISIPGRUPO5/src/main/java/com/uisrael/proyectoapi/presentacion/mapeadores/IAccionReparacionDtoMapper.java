package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionResponseDTO;

@Mapper(componentModel = "spring")
public interface IAccionReparacionDtoMapper {

    @Mapping(target = "idOrden", source = "fkOrden.idOrden")
    AccionReparacionResponseDTO toResponseDto(AccionReparacion accionReparacion);
}
