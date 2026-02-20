package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.UsuarioResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

    private final IUsuarioCasoUso usuarioCasoUso;
    private final IUsuarioDtoMapper mapper;

    public UsuarioControlador(IUsuarioCasoUso usuarioCasoUso, IUsuarioDtoMapper mapper) {
        this.usuarioCasoUso = usuarioCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioCasoUso.listarTodos()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable int id) {
        Usuario u = usuarioCasoUso.buscarPorId(id);
        return mapper.toResponseDto(u);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO crear(@Valid @RequestBody UsuarioRequestDTO request) {
        Usuario dom = mapper.toDomain(request);
        Usuario guardado = usuarioCasoUso.guardar(dom); 
        return mapper.toResponseDto(guardado);
    }
    
    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizar(@PathVariable int id, @Valid @RequestBody UsuarioRequestDTO request) {

        Usuario domSinId = mapper.toDomain(request);

        Usuario domConId = new Usuario(
                id,
                domSinId.getUsuario(),
                domSinId.getNombre(),
                domSinId.getApellido(),
                domSinId.getRol(),
                domSinId.getTelefono(),
                domSinId.getCorreo(),
                domSinId.getCreadoEn(),
                domSinId.isEstado(),
                domSinId.getPasswordHash()
        );

        Usuario actualizado = usuarioCasoUso.guardar(domConId);
        return mapper.toResponseDto(actualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        usuarioCasoUso.eliminar(id);
    }
}
