package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccionReparacionMaterialCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionMaterialRepositorio;

public class AccionReparacionMaterialCasoUsoImpl implements IAccionReparacionMaterialCasoUso {

    private final IAccionReparacionMaterialRepositorio repositorio;

    public AccionReparacionMaterialCasoUsoImpl(IAccionReparacionMaterialRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public AccionReparacionMaterial guardar(AccionReparacionMaterial arm) {
        return repositorio.guardar(arm);
    }

    @Override
    public AccionReparacionMaterial buscarPorId(int idAccionMaterial) {
        return repositorio.buscarPorId(idAccionMaterial)
                .orElseThrow(() -> new RuntimeException("Accion Reparacion Material no encontrado"));
    }

    @Override
    public List<AccionReparacionMaterial> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public List<AccionReparacionMaterial> listarPorAccion(int idAccion) {
        return repositorio.listarPorAccion(idAccion);
    }

    @Override
    public void eliminar(int idAccionMaterial) {
        repositorio.eliminar(idAccionMaterial);
    }
}
