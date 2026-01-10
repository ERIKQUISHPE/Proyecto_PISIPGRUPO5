package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class ClienteJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String apellido;
	private String ci;
	private String telefono;
	private String correo;
	private String direccion;
	
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    private boolean estado; // true: activo - false: eliminado

    @PrePersist
    public void asignarFechaCreacion() {
        this.creadoEn = LocalDateTime.now();
    }
}
