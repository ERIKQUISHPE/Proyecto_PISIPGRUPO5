package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;

public interface IOrdenInternaCasoUso {
OrdenInterna guardar(OrdenInterna ordenInterna);
	
	OrdenInterna buscarPorId(int id);
	
	List<OrdenInterna> listarTodos();
	
	void eliminar(int id);

}
