package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Orden;

public interface IOrdenCasoUso {
	
	Orden crear(Orden orden);
	
	Orden obtenerPorId(int id);
	
	List<Orden> listar();
	
	void eliminar(int id);
}

