package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Prioridad;

public interface IPrioridadCasoUso {
Prioridad guardar(Prioridad prioridad);
	
	Prioridad buscarPorId(int id);
	
	List<Prioridad> listarTodos();
	
	void eliminar(int id);

}
