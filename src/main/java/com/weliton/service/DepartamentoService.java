package com.weliton.service;

import java.util.List;

import com.weliton.domain.Departamento;

public interface DepartamentoService {
	
	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void excluir(Long id);

	Departamento buscarPorId(Long id);

	List<Departamento> BuscarTodos();
}
