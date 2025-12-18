package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prioridades")
public class PrioridadJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int idPrioridad;

    private String nombre;
}
