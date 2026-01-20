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
@Table(name = "ordenes_internas")
public class OrdenInternaJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenInterna;
    private int tecnicoId;
    private int estadoId;
    private String diagnostico;
    private String observaciones;
    private int creadoPor;
    @CreationTimestamp
	@Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;
   
    @ManyToOne
	@JoinColumn(name = "fkOrden")
	private OrdenJpa fkOrden;
}
