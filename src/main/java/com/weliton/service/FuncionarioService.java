package com.weliton.service;

import java.util.List;

import com.weliton.domain.Funcionario;

public interface FuncionarioService {
	void salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario buscarPorId(Long id);

	List<Funcionario> BuscarTodos();
}
