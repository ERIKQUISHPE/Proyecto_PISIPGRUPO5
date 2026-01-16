package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estados_orden")
public class EstadoOrdenJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int idEstado;
    private String nombre;
    
    @OneToMany(mappedBy = "fkEstadoOrden")
    private List<OrdenJpa> orden;
}
