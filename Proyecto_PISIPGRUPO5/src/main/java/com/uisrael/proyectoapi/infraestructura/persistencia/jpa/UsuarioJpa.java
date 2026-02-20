package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;	
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

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
	private String usuario; 
	private String nombre;
	private String apellido;
	private String rol;
	private String telefono;
	private String correo;
	@CreationTimestamp
	@Column(name = "creado_en", nullable = false, updatable = false)
	private LocalDateTime creadoEn;
	private boolean estado; 
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

}