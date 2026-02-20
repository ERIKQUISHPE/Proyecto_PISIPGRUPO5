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
@Table(name = "material")
public class MaterialJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMaterial;
	private String codigoMaterial;
	private String nombre;
	private String descripcion;
	private BigDecimal costoCompra;
	private BigDecimal costoVenta;
	private Integer stock; 
	private boolean estado; 
	
	@ManyToOne
	@JoinColumn(name = "fkProveedor")
	private ProveedorJpa fkProveedor;
	
}
