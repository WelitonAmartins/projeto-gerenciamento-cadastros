package com.weliton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weliton.dao.FuncionarioDao;
import com.weliton.domain.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);

	}
	 
	@Transactional(readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);

	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
	
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> BuscarTodos() {
		
		return dao.findAll();
	}

}
