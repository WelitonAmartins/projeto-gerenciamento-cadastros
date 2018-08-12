package com.weliton.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weliton.domain.Departamento;
import com.weliton.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	
	@Autowired
	private DepartamentoService ds;

	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap map) {
		map.addAttribute("departamentos", ds.BuscarTodos());
		return "departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		ds.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		model.addAttribute("departamento", ds.buscarPorId(id));
		return "/departamento/cadastro";
		
	}
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		ds.editar(departamento);
		return "redirect:/departamentos/cadastrar";
		
	}
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id")Long id, ModelMap model) {
	
		if(!ds.departamentoTemCargo(id)) {
			ds.excluir(id);
		}
		return listar(model);
	}
	
}
