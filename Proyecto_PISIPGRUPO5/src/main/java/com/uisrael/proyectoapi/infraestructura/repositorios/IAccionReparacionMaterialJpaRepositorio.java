package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionMaterialJpa;

public interface IAccionReparacionMaterialJpaRepositorio
        extends JpaRepository<AccionReparacionMaterialJpa, Integer> {

    List<AccionReparacionMaterialJpa> findByFkAccion_IdAccion(int idAccion);
    List<AccionReparacionMaterialJpa> findByFkAccion_FkOrden_IdOrden(int idOrden);
    void deleteByFkAccion_IdAccion(int idAccion);

}
