package com.uisrael.clienteconsumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tipoclientes")
public class TipoClienteController {
	@GetMapping
	public String listar() {
		return "/tipocliente/listartipocliente";
	}

	@GetMapping("nuevotipocliente")
	public String crear() {	
		return "/tipocliente/nuevotipocliente";
	}
}
