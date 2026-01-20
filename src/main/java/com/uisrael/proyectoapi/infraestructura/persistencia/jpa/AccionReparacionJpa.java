package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "acciones_reparacion")
public class AccionReparacionJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccion;
    private int tecnicoId;
    private String descripcion;
    @CreationTimestamp
	@Column(name = "fecha_accion", nullable = false, updatable = false)
    private LocalDateTime fechaAccion;
    
    @ManyToOne
	@JoinColumn(name = "fkOrden")
	private OrdenJpa fkOrden;
}
