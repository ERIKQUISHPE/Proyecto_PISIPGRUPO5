package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionMaterialRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionMaterialJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccionReparacionMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionMaterialJpaRepositorio;

public class AccionReparacionMaterialRepositorioImpl implements IAccionReparacionMaterialRepositorio {

    private final IAccionReparacionMaterialJpaRepositorio jpaRepositorio;
    private final IAccionReparacionMaterialJpaMapper mapper;

    public AccionReparacionMaterialRepositorioImpl(IAccionReparacionMaterialJpaRepositorio jpaRepositorio,
                                                  IAccionReparacionMaterialJpaMapper mapper) {
        super();
        this.jpaRepositorio = jpaRepositorio;
        this.mapper = mapper;
    }

    @Override
    public AccionReparacionMaterial guardar(AccionReparacionMaterial arm) {
        AccionReparacionMaterialJpa entity = mapper.toEntity(arm);
        entity.setFkAccion(arm.getFkAccion() == null ? null : toAccionJpa(arm.getFkAccion().getIdAccion()));
        entity.setFkMaterial(arm.getFkMaterial() == null ? null : toMaterialJpa(arm.getFkMaterial().getIdMaterial()));

        AccionReparacionMaterialJpa guardado = jpaRepositorio.save(entity);
        return mapper.toDomain(guardado);
    }

    @Override
    public Optional<AccionReparacionMaterial> buscarPorId(int idAccionMaterial) {
        return jpaRepositorio.findById(idAccionMaterial).map(mapper::toDomain);
    }

    @Override
    public List<AccionReparacionMaterial> listarTodos() {
        return jpaRepositorio.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<AccionReparacionMaterial> listarPorAccion(int idAccion) {
        return jpaRepositorio.findByFkAccion_IdAccion(idAccion).stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(int idAccionMaterial) {
        jpaRepositorio.deleteById(idAccionMaterial);
    }

    private com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa toAccionJpa(int idAccion) {
        com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa a =
                new com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa();
        a.setIdAccion(idAccion);
        return a;
    }

    private com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa toMaterialJpa(int idMaterial) {
        com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa m =
                new com.uisrael.proyectoapi.infraestructura.persistencia.jpa.MaterialJpa();
        m.setIdMaterial(idMaterial);
        return m;
    }
}
