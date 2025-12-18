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
@Table(name = "usuario")
public class UsuarioJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String Usuario; // Se coloca el nombre de Usuario para el ingreso. Debe ser único.
	private String nombre;
	private String apellido;
	private String rol;
	private String telefono;
	private String correo;
	@Column(name = "creado en",length = 80)
	private LocalDateTime creadoEn;
	private boolean estado; //true: activo - false: eliminado
	
}