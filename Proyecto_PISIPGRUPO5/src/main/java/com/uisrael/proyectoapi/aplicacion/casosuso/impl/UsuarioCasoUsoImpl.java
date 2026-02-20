package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.dominio.repositorios.IUsuarioRepositorio;

public class UsuarioCasoUsoImpl implements IUsuarioCasoUso {

    private final IUsuarioRepositorio repositorio;
    private final BCryptPasswordEncoder encoder;

    public UsuarioCasoUsoImpl(IUsuarioRepositorio repositorio, BCryptPasswordEncoder encoder) {
        this.repositorio = repositorio;
        this.encoder = encoder;
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        String ph = usuario.getPasswordHash();

        if (ph != null && !ph.isBlank() && !ph.startsWith("$2")) {
            String hash = encoder.encode(ph);

            Usuario usuarioConHash = new Usuario(
                    usuario.getIdUsuario(),
                    usuario.getUsuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getRol(),
                    usuario.getTelefono(),
                    usuario.getCorreo(),
                    usuario.getCreadoEn(),
                    usuario.isEstado(),
                    hash
            );

            return repositorio.guardar(usuarioConHash);
        }

        if (usuario.getIdUsuario() > 0 && (ph == null || ph.isBlank())) {
            var anterior = repositorio.buscarPorId(usuario.getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            Usuario usuarioSinCambiarClave = new Usuario(
                    usuario.getIdUsuario(),
                    usuario.getUsuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getRol(),
                    usuario.getTelefono(),
                    usuario.getCorreo(),
                    usuario.getCreadoEn(),
                    usuario.isEstado(),
                    anterior.getPasswordHash()
            );

            return repositorio.guardar(usuarioSinCambiarClave);
        }
        return repositorio.guardar(usuario);
    }

    @Override
    public Usuario buscarPorId(int idUsuario) {
        return repositorio.buscarPorId(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idUsuario) {
        repositorio.eliminar(idUsuario);
    }
}
