package com.weliton.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weliton.domain.Cargo;
import com.weliton.domain.Departamento;
import com.weliton.service.CargoService;
import com.weliton.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cs;
	
	@Autowired
	private DepartamentoService dps;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "cargo/lista";
	}
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cs.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo salvo com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamento(){
		return dps.BuscarTodos();
	}
	

}
