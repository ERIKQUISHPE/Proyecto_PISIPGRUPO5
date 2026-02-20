package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;

public interface IAccionReparacionMaterialCasoUso {

    AccionReparacionMaterial guardar(AccionReparacionMaterial arm);

    AccionReparacionMaterial buscarPorId(int idAccionMaterial);

    List<AccionReparacionMaterial> listarTodos();

    List<AccionReparacionMaterial> listarPorAccion(int idAccion);

    void eliminar(int idAccionMaterial);
}
