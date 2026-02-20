package com.uisrael.clienteconsumo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.clienteconsumo.model.dto.request.MaterialRequestDTO;
import com.uisrael.clienteconsumo.model.dto.request.ProveedorRequestDTO;
import com.uisrael.clienteconsumo.model.dto.response.MaterialResponseDTO;
import com.uisrael.clienteconsumo.model.dto.response.ProveedorResponseDTO;
import com.uisrael.clienteconsumo.service.IMaterialServicio;
import com.uisrael.clienteconsumo.service.IProveedorServicio;

@Controller
@RequestMapping("/materiales")
public class MaterialController {

	@Autowired
	private IMaterialServicio materialServicio;

	@Autowired
	private IProveedorServicio proveedorServicio;

	@GetMapping
	public String listar(Model model) {
		List<MaterialResponseDTO> resultado = materialServicio.listarMaterial();
		model.addAttribute("listamaterial", resultado);
		return "inventario/material/listarmaterial";
	}

	@GetMapping("/nuevo")
	public String crear(@RequestParam(value = "proveedorId", required = false) Integer proveedorId, Model model) {
		List<ProveedorResponseDTO> proveedores = proveedorServicio.listarProveedor();
		MaterialRequestDTO material = new MaterialRequestDTO();
		material.setFkProveedor(new ProveedorRequestDTO()); // evita null
		if (proveedorId != null && proveedorId > 0) {
			material.getFkProveedor().setIdProveedor(proveedorId);
		}
		model.addAttribute("material", material);
		model.addAttribute("listaproveedor", proveedores);
		model.addAttribute("returnToProveedor", "/materiales/nuevo");
		return "inventario/material/nuevomaterial";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("material") MaterialRequestDTO dto, Model model) {

		String codigoNuevo = (dto.getCodigoMaterial() == null) ? "" : dto.getCodigoMaterial().trim();

		List<MaterialResponseDTO> materiales = materialServicio.listarMaterial();
		for (MaterialResponseDTO m : materiales) {
			String codigoExistente = (m.getCodigoMaterial() == null) ? "" : m.getCodigoMaterial().trim();

			if (!codigoNuevo.isEmpty() && codigoExistente.equalsIgnoreCase(codigoNuevo)) {
				model.addAttribute("error", "Ya existe un material con ese código");
				model.addAttribute("material", dto);
				model.addAttribute("listaproveedor", proveedorServicio.listarProveedor());
				model.addAttribute("returnToProveedor", "/materiales/nuevo");
				return "inventario/material/nuevomaterial";
			}
		}

		materialServicio.crearMaterial(dto);
		return "redirect:/materiales";
	}

	@GetMapping("/editar")
	public String editar(@RequestParam int idMaterial, Model model) {

		MaterialResponseDTO materialResp = materialServicio.buscarPorId(idMaterial);

		MaterialRequestDTO material = new MaterialRequestDTO();
		material.setIdMaterial(idMaterial);
		material.setCodigoMaterial(materialResp.getCodigoMaterial());
		material.setNombre(materialResp.getNombre());
		material.setDescripcion(materialResp.getDescripcion());
		material.setCostoCompra(materialResp.getCostoCompra());
		material.setCostoVenta(materialResp.getCostoVenta());
		material.setStock(materialResp.getStock());
		material.setEstado(materialResp.isEstado());

		if (materialResp.getFkProveedor() != null) {
			ProveedorRequestDTO proveedor = new ProveedorRequestDTO();
			proveedor.setIdProveedor(materialResp.getFkProveedor().getIdProveedor());
			material.setFkProveedor(proveedor);
		} else {
			material.setFkProveedor(new ProveedorRequestDTO());
		}

		model.addAttribute("material", material);
		model.addAttribute("listaproveedor", proveedorServicio.listarProveedor());
		model.addAttribute("proveedorFijado", false);

		return "inventario/material/nuevomaterial";
	}

	@PostMapping("/actualizar/{id}")
	public String actualizar(@PathVariable int id, @ModelAttribute("material") MaterialRequestDTO dto, Model model) {
		String codigoNuevo = (dto.getCodigoMaterial() == null) ? "" : dto.getCodigoMaterial().trim();
		List<MaterialResponseDTO> materiales = materialServicio.listarMaterial();
		for (MaterialResponseDTO m : materiales) {
			String codigoExistente = (m.getCodigoMaterial() == null) ? "" : m.getCodigoMaterial().trim();
			if (m.getIdMaterial() != id && !codigoNuevo.isEmpty() && codigoExistente.equalsIgnoreCase(codigoNuevo)) {
				model.addAttribute("error", "Ya existe un material con ese código");
				dto.setIdMaterial(id);
				model.addAttribute("material", dto);
				model.addAttribute("listaproveedor", proveedorServicio.listarProveedor());
				model.addAttribute("proveedorFijado", false);
				return "inventario/material/nuevomaterial";
			}
		}
		materialServicio.actualizarMaterial(id, dto);
		return "redirect:/materiales";
	}

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam int idMaterial) {
		materialServicio.eliminarMaterial(idMaterial);
		return "redirect:/materiales";
	}
}
