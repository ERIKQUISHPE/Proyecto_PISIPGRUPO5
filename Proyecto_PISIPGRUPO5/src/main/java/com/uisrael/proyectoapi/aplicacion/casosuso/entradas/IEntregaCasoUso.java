package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Entrega;

public interface IEntregaCasoUso {
Entrega guardar(Entrega entrega);
	
	Entrega buscarPorId(int idEntrega);
	
	List<Entrega> listarTodos();
	
	void eliminar(int idEntrega);

}
