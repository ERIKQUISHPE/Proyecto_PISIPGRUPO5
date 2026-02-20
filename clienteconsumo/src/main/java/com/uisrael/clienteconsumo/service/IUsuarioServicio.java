package com.uisrael.clienteconsumo.service;

import java.util.List;

import com.uisrael.clienteconsumo.model.dto.request.UsuarioRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.UsuarioResponseDTO;

public interface IUsuarioServicio {

    List<UsuarioResponseDTO> listarUsuario();

    UsuarioResponseDTO buscarUsuarioPorId(int id);

    void crearUsuario(UsuarioRequestDTO dto);

    void actualizarUsuario(int id, UsuarioRequestDTO dto);

    void eliminarUsuario(int id);
}
