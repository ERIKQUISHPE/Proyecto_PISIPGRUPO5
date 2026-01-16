package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "orden_materiales")
public class OrdenMaterialJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenMaterial;
    private int cantidad;
    private BigDecimal costoUnitario;
    private BigDecimal precioUnitario;
    
    @ManyToOne
	@JoinColumn(name = "fkOrden")
	private OrdenJpa fkOrden;
    
    @ManyToOne
	@JoinColumn(name = "fkMaterial")
	private MaterialJpa fkMaterial;
    
}
