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
@Table(name = "entregas")
public class EntregaJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrega;
    private int entregadoPor;
    private int recibidoPor;
    @CreationTimestamp
	@Column(name = "fecha_entrega", nullable = false, updatable = false)
    private LocalDateTime fechaEntrega;
    private String notas;
    
    @ManyToOne
	@JoinColumn(name = "fkOrden")
	private OrdenJpa fkOrden;
}
