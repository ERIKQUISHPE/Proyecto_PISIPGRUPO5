package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;
import com.uisrael.proyectoapi.presentacion.dto.request.AccionReparacionMaterialRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.AccionReparacionMaterialResponseDTO;

@Mapper(componentModel = "spring")
public interface IAccionReparacionMaterialDtoMapper {

    @Mapping(target = "idAccionMaterial", ignore = true)
    @Mapping(target = "fkAccion", ignore = true)
    @Mapping(target = "fkMaterial", ignore = true)
    AccionReparacionMaterial toDomain(AccionReparacionMaterialRequestDTO dto);

    @Mapping(target = "idAccion", expression = "java(arm.getFkAccion() != null ? arm.getFkAccion().getIdAccion() : null)")
    @Mapping(target = "idMaterial", expression = "java(arm.getFkMaterial() != null ? arm.getFkMaterial().getIdMaterial() : null)")
    AccionReparacionMaterialResponseDTO toResponseDto(AccionReparacionMaterial arm);
}
