package com.uisrael.clienteconsumo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.UsuarioRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.UsuarioResponseDTO;
import com.uisrael.clienteconsumo.service.IUsuarioServicio;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping
    public String listar(Model model) {
        List<UsuarioResponseDTO> resultado = usuarioServicio.listarUsuario();
        model.addAttribute("listausuario", resultado);
        return "usuario/listarusuario";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new UsuarioRequestDTO());
        model.addAttribute("modo", "nuevo");
        return "usuario/nuevousuario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuario") UsuarioRequestDTO dto) {
        usuarioServicio.crearUsuario(dto);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        UsuarioResponseDTO u = usuarioServicio.buscarUsuarioPorId(id);

        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setIdUsuario(u.getIdUsuario());
        dto.setUsuario(u.getUsuario());
        dto.setNombre(u.getNombre());
        dto.setApellido(u.getApellido());
        dto.setRol(u.getRol());
        dto.setTelefono(u.getTelefono());
        dto.setCorreo(u.getCorreo());
        dto.setEstado(u.isEstado());
        dto.setPassword("");

        model.addAttribute("usuario", dto);
        model.addAttribute("modo", "editar");
        return "usuario/nuevousuario";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("usuario") UsuarioRequestDTO dto) {
        usuarioServicio.actualizarUsuario(dto.getIdUsuario(), dto);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}
