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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.clienteconsumo.model.dto.request.ProveedorRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.ProveedorResponseDTO;
import com.uisrael.clienteconsumo.service.IProveedorServicio;

@Controller
@RequestMapping("/proveedores") //
public class ProveedorController {

	@Autowired
	private IProveedorServicio proveedorServicio;

	@GetMapping
	public String listar(Model model) {
		List<ProveedorResponseDTO> resultado = proveedorServicio.listarProveedor();
		model.addAttribute("listaproveedor", resultado);
		return "/proveedor/listarproveedor";
	}

	@GetMapping("/nuevo")
	public String nuevo(@RequestParam(value = "returnTo", required = false) String returnTo, Model model) {
		model.addAttribute("proveedor", new ProveedorRequestDTO());
		model.addAttribute("returnTo", returnTo);
		return "/proveedor/nuevoproveedor";
	}

	@GetMapping("/editar")
	public String editar(int idProveedor, Model model) {
		ProveedorResponseDTO proveedor = null;
		for (ProveedorResponseDTO editarProveedor : proveedorServicio.listarProveedor()) {
			if (editarProveedor.getIdProveedor() == idProveedor) {
				proveedor = editarProveedor;
				break;
			}
		}
		if (proveedor == null) {
			return "redirect:/proveedores";
		}
		model.addAttribute("proveedor", proveedor);
		return "/proveedor/nuevoproveedor";
	}

	@PostMapping("/guardar")
	public String guardarProveedor(@ModelAttribute("proveedor") ProveedorRequestDTO dto,
			@RequestParam(required = false) String returnTo, Model model) {

		String correoNuevo = (dto.getCorreo() == null) ? "" : dto.getCorreo().trim();
		String empresaNueva = (dto.getProveedor() == null) ? "" : dto.getProveedor().trim();

		List<ProveedorResponseDTO> proveedores = proveedorServicio.listarProveedor();

		for (ProveedorResponseDTO p : proveedores) {

			String correoExistente = (p.getCorreo() == null) ? "" : p.getCorreo().trim();
			String empresaExistente = (p.getProveedor() == null) ? "" : p.getProveedor().trim();

			if (p.getIdProveedor() != dto.getIdProveedor()) {

				boolean hayError = false;

				if (!correoNuevo.isEmpty() && correoExistente.equalsIgnoreCase(correoNuevo)) {

					model.addAttribute("errorCorreo", "Este correo ya está registrado");
					hayError = true;
				}

				if (!empresaNueva.isEmpty() && empresaExistente.equalsIgnoreCase(empresaNueva)) {

					model.addAttribute("errorEmpresa", "Esta empresa ya está registrada");
					hayError = true;
				}

				if (hayError) {

					model.addAttribute("proveedor", dto);
					model.addAttribute("returnTo", returnTo);

					return "/proveedor/nuevoproveedor";
				}
			}
		}
		proveedorServicio.crearProveedor(dto);

		int nuevoId = proveedorServicio.listarProveedor().stream().mapToInt(ProveedorResponseDTO::getIdProveedor).max()
				.orElse(0);

		if (returnTo != null && !returnTo.isBlank()) {
			return "redirect:" + returnTo + "?proveedorId=" + nuevoId;
		}
		return "redirect:/proveedores";
	}

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam int idProveedor, RedirectAttributes ra) {
		try {
			proveedorServicio.eliminarProveedor(idProveedor);
			ra.addFlashAttribute("msg", "Proveedor eliminado");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "No se pudo eliminar, este proveedor puede tener órdenes asociadas");
		}
		return "redirect:/proveedores";
	}

}