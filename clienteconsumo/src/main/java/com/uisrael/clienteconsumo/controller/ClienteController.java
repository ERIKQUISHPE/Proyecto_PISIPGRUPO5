package com.uisrael.clienteconsumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listarclientes") // url
public class ClienteController {

    @GetMapping
    public String listar() {
        return "/cliente/listarcliente"; // ruta fisica de la pagina
    }

    @GetMapping("/nuevo")
    public String crear() {
        return "/cliente/nuevocliente"; // ruta fisica de la pagina
    }
}
