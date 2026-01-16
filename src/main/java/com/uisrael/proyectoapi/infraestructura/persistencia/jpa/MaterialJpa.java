package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private Integer stock; // Puede ser null
	private boolean estado; //true: activo - false: eliminado
	
	@ManyToOne
	@JoinColumn(name = "fkOrden")
	private OrdenJpa fkOrden;
	
	@ManyToOne
	@JoinColumn(name = "fkProveedor")
	private ProveedorJpa fkProveedor;
	
	@OneToMany(mappedBy = "fkMaterial")
    private List<OrdenMaterialJpa> orden_material;
}
