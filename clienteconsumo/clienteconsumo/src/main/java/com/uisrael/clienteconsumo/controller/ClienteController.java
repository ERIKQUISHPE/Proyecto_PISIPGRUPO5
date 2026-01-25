package com.uisrael.clienteconsumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clientes")
public class ClienteController {
	@GetMapping
	public String listar() {
		return "/cliente/listarcliente";
	}
	@GetMapping ("nuevo")
	public String crear() {
		return "/cliente/nuevocliente";
	}
}
