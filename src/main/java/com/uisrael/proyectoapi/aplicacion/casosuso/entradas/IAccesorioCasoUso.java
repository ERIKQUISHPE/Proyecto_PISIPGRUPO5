package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Accesorio;

public interface IAccesorioCasoUso {
	Accesorio guardar(Accesorio accesorio);

	Accesorio buscarPorId(int id);

	List<Accesorio> listarTodos();

	void eliminar(int id);
}
