package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.UsuarioRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.UsuarioResponseDTO;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    private final WebClient webusuario;

    public UsuarioServicioImpl(WebClient webusuario) {
        this.webusuario = webusuario;
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuario() {
        return webusuario.get()
                .uri("/usuario")
                .retrieve()
                .bodyToFlux(UsuarioResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(int id) {
        return webusuario.get()
                .uri("/usuario/{id}", id)
                .retrieve()
                .bodyToMono(UsuarioResponseDTO.class)
                .block();
    }

    @Override
    public void crearUsuario(UsuarioRequestDTO dto) {
        webusuario.post()
                .uri("/usuario")
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void actualizarUsuario(int id, UsuarioRequestDTO dto) {
        webusuario.put()
                .uri("/usuario/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarUsuario(int id) {
        webusuario.delete()
                .uri("/usuario/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
