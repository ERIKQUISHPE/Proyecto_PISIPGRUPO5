package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;

public interface IUsuarioCasoUso {
Usuario guardar(Usuario usuario);
	
	Usuario buscarPorId(int id);
	
	List<Usuario> listarTodos();
	
	void eliminar(int id);

}
