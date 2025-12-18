package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class ProveedorJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String Proveedor;
	private String nombreContacto;
	private String apellidoContacto;
	private String telefono;
	private String correo;
	private String notas;
	@Column(name = "creado en",length = 80)
	private LocalDateTime creadoEn;
	private boolean estado; //true: activo - false: eliminado
}
