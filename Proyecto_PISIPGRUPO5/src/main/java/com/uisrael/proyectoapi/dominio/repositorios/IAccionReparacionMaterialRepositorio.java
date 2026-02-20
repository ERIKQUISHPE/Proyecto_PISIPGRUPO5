package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;

public interface IAccionReparacionMaterialRepositorio {

    AccionReparacionMaterial guardar(AccionReparacionMaterial arm);

    Optional<AccionReparacionMaterial> buscarPorId(int idAccionMaterial);

    List<AccionReparacionMaterial> listarTodos();

    List<AccionReparacionMaterial> listarPorAccion(int idAccion);

    void eliminar(int idAccionMaterial);
}
