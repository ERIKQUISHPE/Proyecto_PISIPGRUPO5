package com.uisrael.clienteconsumo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteconsumo.model.dto.request.PagoRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.PagoResponseDTO;
import com.uisrael.clienteconsumo.service.IPagoServicio;

@Service
public class PagoServicioImpl implements IPagoServicio {
	private final WebClient webpago;

	public PagoServicioImpl(WebClient webpago) {
		this.webpago = webpago;
	}

	@Override
	public List<PagoResponseDTO> listarPago() {
		return webpago.get().uri("/pago").retrieve().bodyToFlux(PagoResponseDTO.class).collectList().block();
	}

	@Override
	public void crearPago(PagoRequestDTO dto) {
		webpago.post().uri("/pago").bodyValue(dto).retrieve().toBodilessEntity().block();
		
	}
	
	@Override
    public PagoResponseDTO buscarPorId(int idPago) {
        return webpago.get()
                .uri("/pago/{id}", idPago)
                .retrieve()
                .bodyToMono(PagoResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarPago(int idPago, PagoRequestDTO dto) {
        webpago.put()
                .uri("/pago/{id}", idPago)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
    
    @Override
    public void eliminarPago(int idPago) {
        webpago.delete()
                .uri("/pago/{id}", idPago)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
	
	
}
