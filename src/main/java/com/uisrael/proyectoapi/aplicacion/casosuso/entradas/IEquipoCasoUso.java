package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Equipo;

public interface IEquipoCasoUso {
Equipo guardar(Equipo equipo);
	
	Equipo buscarPorId(int id);
	
	List<Equipo> listarTodos();
	
	void eliminar(int id);

}
