package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacion;

public interface IAccionReparacionCasoUso {
AccionReparacion guardar(AccionReparacion accionReparacion);
	
	AccionReparacion buscarPorId(int idAccionReparacion);
	
	List<AccionReparacion> listarTodos();
	
	void eliminar(int idAccionReparacion);

}
