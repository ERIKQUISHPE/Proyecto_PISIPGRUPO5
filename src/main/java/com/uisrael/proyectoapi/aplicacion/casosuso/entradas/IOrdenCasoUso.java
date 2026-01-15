package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
public interface IOrdenCasoUso {
	
	Orden guardar(Orden orden);
	
	Orden buscarPorId(int id);
	
	List<Orden> listarTodos();
	
	void eliminar(int id);
}

