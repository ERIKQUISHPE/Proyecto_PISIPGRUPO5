package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;


import com.uisrael.proyectoapi.dominio.entidades.Proveedor;

public interface IProveedorCasoUso {
	
	Proveedor guardar(Proveedor proveedor);
	
	Proveedor buscarPorId(int idProveedor);
	
	List<Proveedor> listarTodos();
	
	void eliminar(int idProveedor);

}
