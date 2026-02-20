package com.uisrael.clienteconsumo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.clienteconsumo.model.dto.request.ClienteRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ClienteResponseDTO;
import com.uisrael.clienteconsumo.service.IClienteServicio;

@Controller
@RequestMapping("/clientes") 
public class ClienteController {

	@Autowired
	private IClienteServicio clienteServicio;

	@GetMapping
	public String listar(Model model) {
		List<ClienteResponseDTO> resultado = clienteServicio.listarCliente();
		model.addAttribute("listacliente", resultado);
		return "/cliente/listarcliente";
	}

	@GetMapping("/nuevo")
	public String nuevo(@RequestParam(value = "returnTo", required = false) String returnTo, Model model) {
		model.addAttribute("cliente", new ClienteRequestDTO());
		model.addAttribute("returnTo", returnTo);
		return "/cliente/nuevocliente";
	}

	@GetMapping("/editar")
	public String editar(int idCliente, Model model) {
		ClienteResponseDTO cliente = null;
		for (ClienteResponseDTO editarCliente : clienteServicio.listarCliente()) {
			if (editarCliente.getIdCliente() == idCliente) {
				cliente = editarCliente;
				break;
			}
		}
		if (cliente == null) {
			return "redirect:/clientes";
		}
		model.addAttribute("cliente", cliente);
		return "/cliente/nuevocliente";
	}

	@PostMapping("/guardar")
	public String guardarCliente(@ModelAttribute("cliente") ClienteRequestDTO dto,
	                             @RequestParam(required = false) String returnTo,
	                             Model model) {
	    model.addAttribute("returnTo", returnTo);
	    String ci = (dto.getCi() == null) ? "" : dto.getCi().trim();
	    String correo = (dto.getCorreo() == null) ? "" : dto.getCorreo().trim();
	    if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()
	            || dto.getApellido() == null || dto.getApellido().trim().isEmpty()
	            || ci.isEmpty() || correo.isEmpty()) {
	        model.addAttribute("error",
	                "No se puede guardar. Debes completar correctamente Nombre, Apellido, Cédula y Correo.");
	        return "/cliente/nuevocliente";
	    }
	    if (!ci.matches("\\d{10}")) {
	        model.addAttribute("errorCi", "La cédula debe tener 10 dígitos.");
	        model.addAttribute("error", "No se puede guardar. Revisa los campos marcados.");
	        return "/cliente/nuevocliente";
	    }
	    if (!correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
	        model.addAttribute("errorCorreo", "Correo inválido. Ej: nombre@dominio.com");
	        model.addAttribute("error", "No se puede guardar. Revisa los campos marcados.");
	        return "/cliente/nuevocliente";
	    }
	    try {
	        clienteServicio.crearCliente(dto);
	        if (returnTo != null && !returnTo.isBlank()) {
	            return "redirect:" + returnTo;
	        }
	        return "redirect:/clientes";
	    } catch (WebClientResponseException ex) {
	        if (ex.getStatusCode().value() == 409) {
	            String body = ex.getResponseBodyAsString();
	            model.addAttribute("errorCi", null);
	            model.addAttribute("errorCorreo", null);
	            if (body != null && body.contains("DUPLICADO_CI")) {
	                model.addAttribute("errorCi", "Cédula ya registrada.");
	                model.addAttribute("error", "No se puede guardar. Corrige los campos marcados.");
	            } else if (body != null && body.contains("DUPLICADO_CORREO")) {
	                model.addAttribute("errorCorreo", "Correo ya registrado.");
	                model.addAttribute("error", "No se puede guardar. Corrige los campos marcados.");
	            } else {
	                model.addAttribute("error", "No se puede guardar. Cédula o correo ya registrados.");
	            }
	            return "/cliente/nuevocliente";
	        }
	        model.addAttribute("error", "No se pudo guardar. Intenta nuevamente.");
	        return "/cliente/nuevocliente";
	    }
	}


	@GetMapping("/eliminar")
	public String eliminar(@RequestParam int idCliente, RedirectAttributes ra) {
		try {
			clienteServicio.eliminarCliente(idCliente);
			ra.addFlashAttribute("msg", "Cliente eliminado");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "No se pudo eliminar, este cliente puede tener órdenes asociadas");
		}
		return "redirect:/clientes";
	}

}