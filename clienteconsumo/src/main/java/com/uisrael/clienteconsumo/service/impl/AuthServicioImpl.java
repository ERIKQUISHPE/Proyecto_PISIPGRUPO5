package com.uisrael.clienteconsumo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uisrael.clienteconsumo.model.dto.request.LoginRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.LoginResponseDTO;
import com.uisrael.clienteconsumo.service.IAuthServicio;

@Service
public class AuthServicioImpl implements IAuthServicio {

    private final RestTemplate rt = new RestTemplate();

    @Value("${api.base-url}")
    private String apiBaseUrl;

    @Override
    public LoginResponseDTO login(String usuario, String password) {

        String url = apiBaseUrl + "/auth/login";

        LoginRequestDTO body = new LoginRequestDTO(usuario, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequestDTO> req = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<LoginResponseDTO> res =
                    rt.exchange(url, HttpMethod.POST, req, LoginResponseDTO.class);

            return res.getBody();

        } catch (Exception e) {
            return null;
        }
    }
}
